package com.shop.model;

import com.shop.dto.Category;
import com.shop.dto.Notice;
import com.shop.dto.Product;
import com.shop.dto.Receive;
import com.shop.vo.ProductListVO;
import com.shop.vo.ProfitVO;
import org.checkerframework.checker.units.qual.A;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Category> getCategoryList() {
        List<Category> cateList = new ArrayList<Category>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.CATEGORY_LOAD);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Category cate = new Category();
                cate.setCno(rs.getString("cno"));
                cate.setCname(rs.getString("cname"));
                cateList.add(cate);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cateList;
    }

    public List<ProductListVO> getProductVOList() {
        List<ProductListVO> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.SELECT_PRODUCTVO);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ProductListVO pro = new ProductListVO();
                pro.setPname(rs.getString("pname"));
                pro.setCname(rs.getString("cname"));
                pro.setRprice(rs.getInt("rprice"));
                pro.setPrice(rs.getInt("price"));
                pro.setAmount(rs.getInt("amount"));

                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getProductList() {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_SELECT_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getCateProductListLimit(String cate, int pageSize) {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_LIST_CATE_LIMIT);
            pstmt.setString(1, cate);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getProductListLimit(int pageSize) {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_LIST_LIMIT);
            pstmt.setInt(1, pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product pro = new Product();
                pro.setPno(rs.getInt("pno"));
                pro.setCate(rs.getString("cate"));
                pro.setProno(rs.getString("prono"));
                pro.setPname(rs.getString("pname"));
                pro.setPcomment(rs.getString("pcomment"));
                pro.setPlist(rs.getString("plist"));
                pro.setPrice(rs.getInt("price"));
                pro.setImgSrc1(rs.getString("imgsrc1"));
                pro.setImgSrc2(rs.getString("imgsrc2"));
                pro.setImgSrc3(rs.getString("imgsrc3"));
                pro.setResdate(rs.getString("resdate"));
                proList.add(pro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return proList;
    }

    public List<Product> getBestProductList(int limit) {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_BEST_PRODUCT_LIST);
            pstmt.setInt(1, limit);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setPno(rs.getInt("pno"));
                product.setCate(rs.getString("cate"));
                product.setProno(rs.getString("prono"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setImgSrc1(rs.getString("imgsrc1"));
                proList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proList;
    }

    public List<Product> getNewProductList(int limit) {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_NEW_PRODUCT_LIST);
            pstmt.setInt(1, limit);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product = new Product();
                product.setPno(rs.getInt("pno"));
                product.setCate(rs.getString("cate"));
                product.setProno(rs.getString("prono"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setImgSrc1(rs.getString("imgsrc1"));
                proList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proList;
    }

    public Product getProduct(int pno) {
        Product product =new Product();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_PNO_PRODUCT);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                product.setPno(rs.getInt("pno"));
                product.setCate(rs.getString("cate"));
                product.setProno(rs.getString("prono"));
                product.setPname(rs.getString("pname"));
                product.setPcomment(rs.getString("pcomment"));
                product.setPlist(rs.getString("plist"));
                product.setPrice(rs.getInt("price"));
                product.setImgSrc1(rs.getString("imgsrc1"));
                product.setImgSrc2(rs.getString("imgsrc2"));
                product.setImgSrc3(rs.getString("imgsrc3"));
                product.setResdate(rs.getString("resdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public int getAmount(int pno) {
        int amount = 0;
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.INVENTORY_SELECT_ONE);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                amount = rs.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }

    public List<Product> getRelated(int pno) {
        List<Product> proList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_RELATED);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Product product =new Product();
                product.setPno(rs.getInt("pno"));
                product.setCate(rs.getString("cate"));
                product.setProno(rs.getString("prono"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getInt("price"));
                product.setImgSrc1(rs.getString("imgsrc1"));
                proList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return proList;
    }

    public int addProduct(Product pro) {
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT);
            pstmt.setString(1, pro.getCate());
            pstmt.setString(2, pro.getPname());
            pstmt.setString(3, pro.getPcomment());
            pstmt.setString(4, pro.getPlist());
            pstmt.setInt(5, pro.getPrice());
            pstmt.setString(6, pro.getImgSrc1());
            pstmt.setString(7, pro.getImgSrc2());
            pstmt.setString(8, pro.getImgSrc3());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }

        con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.PRODUCT_INSERT_UPDATE);
            cnt = cnt + pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int addReceive(Receive receive) {
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.RECEIVE_INSERT);
            pstmt.setInt(1, receive.getPno());
            pstmt.setInt(2, receive.getAmount());
            pstmt.setInt(3, receive.getRprice());
            pstmt.setInt(4, receive.getPno());
            pstmt.setInt(5, receive.getAmount());
            pstmt.setInt(6, receive.getPno());
            pstmt.setInt(7, receive.getRprice());
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public int getPrice(int pno) {
        int result = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_PRODUCT_PRICE);
            pstmt.setInt(1, pno);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getInt("price");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ProfitVO> getProductProfit() {
        List<ProfitVO> profitList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.SELECT_PROFIT_LIST);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                ProfitVO profit = new ProfitVO();
                profit.setPname(rs.getString("pname"));
                profit.setSales(rs.getInt("tot"));
                profitList.add(profit);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return profitList;
    }

}
