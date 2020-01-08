package com.gwxtd.core.service.impl;

import java.io.BufferedOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.gwxtd.core.common.AlipayConstant;
import com.gwxtd.core.dao.OrderMapper;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.service.AppPayService;

@Service
@Transactional
public class AppPayServiceImpl implements AppPayService {
	@Autowired
	private OrderMapper orderMapper;
	@Override
	public String getAlipayInfo(long oid,double money) {
		// 实例化客户端
		AlipayClient alipayClient = new DefaultAlipayClient(
				AlipayConstant.SERVER_URL, AlipayConstant.APPID,
				AlipayConstant.RSA2_PRIVATE, "json", "utf-8",
				AlipayConstant.ALIPAY_PUBLIC_KEY, "RSA2");
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setBody("手机平台商品");// 设置商品描述
		model.setSubject("京东app订单支付");// 订单名称
		model.setTimeoutExpress("30m");// 超时关闭该订单时间
		model.setTotalAmount(money+"");// 支付总金额
		model.setProductCode("QUICK_MSECURITY_PAY");// 设置销售产品码
		model.setOutTradeNo(oid+"");// 设置订单号
		request.setBizModel(model);
		request.setNotifyUrl(AlipayConstant.NOTIFY_URL);//商户外网可以访问的异步地址
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient
					.sdkExecute(request);
			System.out.println(response.getBody());// 就是orderString
													// 可以直接给客户端请求，无需再做处理。
			return response.getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void notifyOrderInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String result = "";
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter
				.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			/* valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8"); */
			params.put(name, valueStr);
			System.out.println("name:" + name + ",valueStr:" + valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params,
				AlipayConstant.ALIPAY_PUBLIC_KEY, "utf-8", "RSA2"); // 调用SDK验证签名
		// 商户订单号
		String out_trade_no = request.getParameter("out_trade_no");
		// 交易状态
		String trade_status = request.getParameter("trade_status");
		String trade_no = request.getParameter("trade_no");// 交易流水号
		if (signVerified) { // 验证成功 更新订单信息
			if (trade_status.equals("TRADE_FINISHED")) {
				System.out.println("TRADE_FINISHED");
			}
			if (trade_status.equals("TRADE_SUCCESS")) {
				if (StringUtils.isNotEmpty(out_trade_no)) {
					// 业务逻辑处理
					// 返回给支付宝的 说明接口处理成功 不然会一天24小时调用你接口
					result = "success";
					Order order = new Order();
					order.setOid(Integer.valueOf(out_trade_no));
					order.setOstate("未发货");
					orderMapper.updateByPrimaryKeySelective(order);
				}
				System.out.println("TRADE_SUCCESS");
			}

		} else {
			// 返回给支付宝的 说明接口处理失败
			result = "failure";
		}
		// 下面代码放在业务处理之后，不然业务代码不会执行
		BufferedOutputStream out = new BufferedOutputStream(
				response.getOutputStream());
		out.write(result.getBytes());
		out.flush();
		out.close();
	}

}
