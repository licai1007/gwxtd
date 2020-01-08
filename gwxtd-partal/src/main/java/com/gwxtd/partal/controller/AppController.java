package com.gwxtd.partal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gwxtd.core.appbean.Banner;
import com.gwxtd.core.appbean.RArea;
import com.gwxtd.core.appbean.RBrand;
import com.gwxtd.core.appbean.RCategory;
import com.gwxtd.core.appbean.RCommentCount;
import com.gwxtd.core.appbean.RGoodComment;
import com.gwxtd.core.appbean.RLoginResult;
import com.gwxtd.core.appbean.ROrderDetails;
import com.gwxtd.core.appbean.ROrderListBean;
import com.gwxtd.core.appbean.ROrderParam;
import com.gwxtd.core.appbean.RProductComment;
import com.gwxtd.core.appbean.RProductInfo;
import com.gwxtd.core.appbean.RProductList;
import com.gwxtd.core.appbean.RReceiver;
import com.gwxtd.core.appbean.RRecommendProduct;
import com.gwxtd.core.appbean.RResult;
import com.gwxtd.core.appbean.RSecondKill;
import com.gwxtd.core.appbean.RShopCar;
import com.gwxtd.core.appbean.SAddOrderParam;
import com.gwxtd.core.appbean.SProductList;
import com.gwxtd.core.common.JsonUtils;
import com.gwxtd.core.pojo.User;
import com.gwxtd.core.service.AppAreaService;
import com.gwxtd.core.service.AppBannerService;
import com.gwxtd.core.service.AppBrandService;
import com.gwxtd.core.service.AppCategoryService;
import com.gwxtd.core.service.AppCommentService;
import com.gwxtd.core.service.AppPayService;
import com.gwxtd.core.service.AppProductService;
import com.gwxtd.core.service.AppReceiverService;
import com.gwxtd.core.service.AppRecommendService;
import com.gwxtd.core.service.AppSecondKillService;
import com.gwxtd.core.service.GoodsService;
import com.gwxtd.core.service.OrderService;
import com.gwxtd.core.service.UserService;

@Controller
@RequestMapping("/app")
public class AppController {
	@Autowired
	private UserService userService;
	@Autowired
	private AppBannerService appBannerService;
	@Autowired
	private AppSecondKillService appSecondKillService;
	@Autowired
	private AppRecommendService appRecommendService;
	@Autowired
	private AppCategoryService appCategoryService;
	@Autowired
	private AppBrandService appBrandService;
	@Autowired
	private AppProductService appProductService;
	@Autowired
	private AppCommentService appCommentService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AppReceiverService appReceiverService;
	@Autowired
	private AppAreaService appAreaService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private AppPayService appPayService;
	@RequestMapping(value="/login.html",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String loginApp(User user){
		User ur = userService.selectUser(user);
		RResult rResult = null;
		if(ur!=null){
			RLoginResult rLoginResult = new RLoginResult();
			rLoginResult.setId(ur.getUid().intValue());
			rLoginResult.setUserIcon("");
			rLoginResult.setUserLevel(1);
			rLoginResult.setUserName(ur.getUname());
			int waitPay = orderService.getCountByStatus("待支付",ur.getUid());
			rLoginResult.setWaitPayCount(waitPay);
			int waitReceive = orderService.getCountByStatus("已发货",ur.getUid());
			rLoginResult.setWaitReceiveCount(waitReceive);
			rResult = new RResult(true,"",rLoginResult);
		}else{
			rResult = new RResult(false,"用户名或密码错误!",null);
		}
		String jsonString = JSON.toJSONString(rResult);
		System.out.println("jsonString:"+jsonString);
		return jsonString;
	}
	@RequestMapping(value="/register.html",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String registerApp(User user){
		User ur = userService.selectUserByUname(user.getUname());
		RResult rResult = null;
		if(ur == null){
			boolean flag = userService.userRegister(user);
			if(flag){
				rResult = new RResult(true,"",null);
			}else{
				rResult = new RResult(false,"对不起,注册失败!",null);
			}
		}else{
			rResult = new RResult(false,"对不起,该用户名已经存在!",null);
		}
		String jsonString = JSON.toJSONString(rResult);
		return jsonString;
	}
	@RequestMapping(value="/banner.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String bigAdvert(int adKind){
		List<Banner> list = appBannerService.selectByKind(adKind);
		RResult rResult = new RResult(true,"",list);
		String jsonString = JSON.toJSONString(rResult);
		return jsonString;
	}
	@RequestMapping(value="/seckill.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String secondKill(){
		List<RSecondKill> all = appSecondKillService.selectAll();
		RResult rResult = new RResult(true,"",all);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/getYourFav.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String recommendProduct(){
		List<RRecommendProduct> list = appRecommendService.selectAll();
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/category.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String category(long parentId){
		List<RCategory> list = appCategoryService.selectByParentId(parentId);
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/brand.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String brand(long cid){
		List<RBrand> brands = appBrandService.selectByCid(cid);
		RResult rResult = new RResult(true,"",brands);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/searchProduct.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String searchList(SProductList sProductList){
		List<RProductList> list = appProductService.selectList(sProductList);
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/productInfo.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String productDetail(long id){
		RProductInfo rProductInfo = appProductService.selectById(id);
		RResult rResult = new RResult(true,"",rProductInfo);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/productComment.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String comment(
			@RequestParam(value="productId",required=true) int productId,
			@RequestParam(value="type",required=true,defaultValue="1") int type){
		List<RGoodComment> list = appCommentService.selectByPid(productId,type);
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/commentCount.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String commentCount(long productId){
		RCommentCount commentCount = appCommentService.selectCommentCount(productId);
		RResult rResult = new RResult(true,"",commentCount);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/commentDetail.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String commentDetail(long productId,int type,boolean hasImgCom){
		List<RProductComment> comments = appCommentService.selectComment((int)productId,type,hasImgCom);
		RResult rResult = new RResult(true,"",comments);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/shopcar.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String shopCarList(long productId){
		RShopCar shopCar = goodsService.selectByProductId((int)productId);
		RResult rResult = new RResult(true,"",shopCar);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/receiveAddress.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String receiveAddress(long userId,Boolean isDefault){
		List<RReceiver> receivers = appReceiverService.select((int)userId,isDefault);
		RResult rResult = new RResult(true,"",receivers);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/province.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String getProvince(){
		List<RArea> list = appAreaService.selectAll();
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/city.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String getCity(String fcode){
		List<RArea> list = appAreaService.selectCityByParentCode(fcode);
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/area.html",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String getArea(String fcode){
		List<RArea> list = appAreaService.selectAreaByParentCode(fcode);
		RResult rResult = new RResult(true,"",list);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/addAddress.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String addReceiver(long userId, String name, String phone,
			String addressDetails, Boolean isDefault){
		RResult result = appReceiverService.addReceiver(userId,name,phone,addressDetails,isDefault);
		return JSON.toJSONString(result);
	}
	@RequestMapping(value="/addOrder.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String addOrder(String detail){
		SAddOrderParam param = JsonUtils.jsonToPojo(detail,SAddOrderParam.class);
		ROrderParam orderParam = orderService.handleAppOrder(param);
		RResult rResult = new RResult(true,"",orderParam);
		return JSON.toJSONString(rResult);
	}
	@RequestMapping(value="/getOrderByStatus.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String getOrderByStatus(int status,long userId){
		List<ROrderListBean> list = orderService.getOrderByStatus(status,userId);
		RResult result = new RResult(true,"",list);
		if(list.size()==0){
			result = new RResult(false,"没有订单",null);
		}
		return JSON.toJSONString(result);
	}
	@RequestMapping(value="/confirmOrder.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String confirmOrder(long oid){
		boolean isSuccess = orderService.confirmOrder(oid);
		RResult result = new RResult(isSuccess,"",null);
		if(!isSuccess){
			result.setErrorMsg("系统异常");
		}
		return JSON.toJSONString(result);
	}
	@RequestMapping(value="/getOrderDetail.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String getOrderDetail(long id){
		ROrderDetails orderDetail = orderService.getOrderDetail(id);
		RResult result = new RResult(true,"",orderDetail);
		return JSON.toJSONString(result);
	}
	@RequestMapping(value="/getAlipayInfo.html",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String getAlipayInfo(long oid,double money){
		String orderInfo = appPayService.getAlipayInfo(oid,money);
		RResult result = new RResult(true,"",orderInfo);
		if(orderInfo==null){
			result = new RResult(false,"支付异常","");
		}
		return JSON.toJSONString(result);
	}
	@RequestMapping(value="/notifyOrderInfo.html")
	public void notifyOrderInfo(HttpServletRequest request,HttpServletResponse response){
		try {
			appPayService.notifyOrderInfo(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
