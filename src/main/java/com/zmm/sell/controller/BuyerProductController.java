package com.zmm.sell.controller;

import com.zmm.sell.dataobject.ProductCategory;
import com.zmm.sell.dataobject.ProductInfo;
import com.zmm.sell.service.CategoryService;
import com.zmm.sell.service.ProductServic;
import com.zmm.sell.utils.ResultVOUtil;
import com.zmm.sell.vo.ProductInfoVO;
import com.zmm.sell.vo.ProductVO;
import com.zmm.sell.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:zhangmengmeng
 * Date:2018/9/29
 * Email:65489469@qq.com
 */
@RestController
@RequestMapping("/buyer/product")
@Slf4j
public class BuyerProductController {


    @Autowired
    private ProductServic productServic;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //查询所有上家商品

        List<ProductInfo> productInfoList = productServic.findUpAll();

        log.error("productInfoList = {}",productInfoList);

        //查询类名，一次性查询
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方法
//        for (ProductInfo productInfo:productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //java8 lambda 因为9已经出来，所有建议用java8的lamba的表达式
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByType(categoryTypeList);

        log.error("productCategoryList = {}",productCategoryList);

        List<ProductVO> productVOList = new ArrayList<>();
        //拼接
        for (ProductCategory productCategory:productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {

                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //拷贝bean对象
                    BeanUtils.copyProperties(productInfo,productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setCategoryFoods(productInfoVOList);

            productVOList.add(productVO);
        }

        log.error("productVOList = {}",productVOList);

//        ResultVO resultVO = new ResultVO();
//        resultVO.setCode(200);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);

//        ResultVO resultVO = new ResultVO();
//
//        resultVO.setCode(200);
//        resultVO.setMsg("success");
//
//        ProductVO productVO = new ProductVO();
//        productVO.setCategoryName("name-1");
//        productVO.setCategoryType(11);
//
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productInfoVO.setProductId("sfadasdffdasfd");
//        productInfoVO.setProductName("giousa");
//        productInfoVO.setProductDescription("这个是描述哦");
//        productInfoVO.setProductIcon("http://xxxxx.jpg");
//        productInfoVO.setProductPrice(new BigDecimal(1212));
//
//        productVO.setCategoryFoods(Arrays.asList(productInfoVO,new ProductInfoVO()));
//
//        resultVO.setData(productVO);

        return ResultVOUtil.success(productVOList);
    }


}
