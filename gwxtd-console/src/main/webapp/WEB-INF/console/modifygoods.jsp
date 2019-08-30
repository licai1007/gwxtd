<%@ page contentType="text/html;charset=utf-8"%>
 <html>
   <head>
     <title>商品修改</title>
     <script language="javascript" src="${pageContext.request.contextPath}/res/script/trim.js"></script>
     <script language="javascript">
       function modifyGoods()
       {
         if(document.myform.gname.value.trim()=="")
         {
         	alert("商品名称不能为空!!!");
         	return;
         }
         if(document.myform.gprice.value.trim()=="")
         {
         	alert("商品价格不能为空!!!");
         	return;
         }
         if(isNaN(document.myform.gprice.value*1))
         {
         	alert("商品价格只能是数字!!!");
         	return;
         }
         if(document.myform.gamount.value.trim()=="")
         {
         	alert("商品数量不能为空!!!");
         	return;
         }
         if(isNaN(document.myform.gamount.value*1))
         {
         	alert("商品数量只能是数字!!!");
         	return;
         }
         if(document.myform.gintro.value.trim()=="")
         {
         	alert("商品说明不能为空!!!");
         	return;
         }
         if(document.myform.gbrief.value.trim()=="")
         {
         	alert("商品简介不能为空!!!");
         	return;
         }
         document.myform.submit();
       }
       function deleteGoods(gid,url)
       {
       		if(confirm('您确定删除吗？')){
       			window.location.href="${pageContext.request.contextPath}/manage/goods/delete.do?gid="+gid+"&url="+url;
       		}
       }
     </script>
   </head>
   <body>
     <table width="100%" cellpadding="0" cellspacing="0">
       <tr>
         <td><%@ include file="admintop.jsp" %></td>
       </tr>
       <tr>
         <td align="center">
           <form action="${pageContext.request.contextPath}/manage/goods/modify.do" method="post" name="myform">
             <table>
               <tr>
                 <td>商品名称:</td>
                 <td>
                 	<input type="hidden" name="gid" value="${goods.gid}"/>
                 	<input type="hidden" name="url" value="${url}"/>
                 	<input type="text" name="gname" size="30" value="${goods.gname}"/>
                 </td>
               </tr>
               <tr>
                 <td>商品价格:</td>
                 <td><input type="text" name="gprice" size="30" value="${goods.gprice}"/></td>
               </tr>
               <tr>
                 <td>商品数量:</td>
                 <td><input type="text" name="gamount" size="30" value="${goods.gamount}"/></td>
               </tr>
               <tr>
                 <td>商品类别:</td>
                 <td><input type="text" name="gclass" size="30" value="${goods.gclass}"/></td>
               </tr>
               <tr>
                 <td>图片URL:</td>
                 <td><input type="text" name="gimgurl" size="30" value="${goods.gimgurl}"/></td>
               </tr>
               <tr>
                 <td>商品说明:</td>
               </tr>
               <tr>
                 <td colspan="2">
                   <textarea cols="60" rows="6" name="gintro">${goods.gintro}</textarea>
                 </td>
               </tr>
               <tr>
                 <td>商品简介:</td>
               </tr>
               <tr>
                 <td colspan="2">
                   <textarea cols="60" rows="6" name="gbrief">${goods.gbrief}</textarea>
                 </td>
               </tr>
               <tr align="center">
                 <td colspan="2">
                   <input type="button" value="修改" onclick="modifyGoods()"/>
                   <input type="button" value="删除" onclick="deleteGoods('${goods.gid}','${url}')"/>
                   <input type="button" value="返回" onclick="javascript:history.back()"/>
                 </td>
               </tr>
             </table>
           </form>
         </td>
       </tr>
     </table>
   </body>
 </html>