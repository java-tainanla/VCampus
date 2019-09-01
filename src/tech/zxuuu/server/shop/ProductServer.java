package tech.zxuuu.server.shop;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tech.zxuuu.dao.IProductMapper;
import tech.zxuuu.entity.Product;
import tech.zxuuu.server.main.App;
<<<<<<< HEAD
import java.util.ArrayList;

public class ProductServer {
	public static List<Product> searchProduct(String product) {
		List<Product> result = new ArrayList<>();
=======

public class ProductServer {
	public static List<Product> searchProduct(String product) {
		List<Product> result = null;
>>>>>>> 34e7912ff789559df32cb4e6a2ca946e890d0d4b
		SqlSession sqlSession = null;
		try {
			sqlSession = App.sqlSessionFactory.openSession();
			IProductMapper productMapper = sqlSession.getMapper(IProductMapper.class);
			result = productMapper.searchProduct(product);
			
<<<<<<< HEAD
			sqlSession.commit();//提交查询
=======
			sqlSession.commit();
>>>>>>> 34e7912ff789559df32cb4e6a2ca946e890d0d4b
			}
		catch(Exception e) {
				// sqlSession.rollback();
				e.printStackTrace();
			}
		return result;
		
			}
	
<<<<<<< HEAD
	/*
	 * public static String searchTypeByP_name(String p_name) { String result=null;
	 * SqlSession sqlSession = null; try { sqlSession =
	 * App.sqlSessionFactory.openSession(); IProductMapper productMapper =
	 * sqlSession.getMapper(IProductMapper.class); result =
	 * productMapper.searchTypeByP_name(p_name);
	 * 
	 * System.out.println("server result="+result);
	 * 
	 * sqlSession.commit();//提交查询 } catch(Exception e) { // sqlSession.rollback();
	 * e.printStackTrace(); } return result;
	 * }
	 */
 		
 		
 
     public static List<Product> listProductByType(String type)
     {
    	 List<Product> result = new ArrayList<>();
    	 SqlSession sqlSession = null;
    	 try {
    		 sqlSession = App.sqlSessionFactory.openSession();
    		 IProductMapper productMapper = sqlSession.getMapper(IProductMapper.class);
    		 result = productMapper.listProductByType(type);

    		 sqlSession.commit();//提交查询
    	 }
    	 catch(Exception e) {
    		 // sqlSession.rollback();
    		 e.printStackTrace();
    	 }
    	 return result;
     }
     
     public static List<Product> cartProduct(String buyer)
     {
    	 List<Product> result = new ArrayList<>();
    	 SqlSession sqlSession = null;
    	 try {
    		 sqlSession = App.sqlSessionFactory.openSession();
    		 IProductMapper productMapper = sqlSession.getMapper(IProductMapper.class);
    		 result = productMapper.cartProduct(buyer);
    		 System.out.println("server result="+result);
    		 sqlSession.commit();//提交查询
    	 }
    	 catch(Exception e) {
    		 // sqlSession.rollback();
    		 e.printStackTrace();
    	 }
    	 return result;
     }
}
     


=======

}
>>>>>>> 34e7912ff789559df32cb4e6a2ca946e890d0d4b