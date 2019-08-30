package com.gregs.mall.emall.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gregs.mall.emall.dao.ProductCategoryRepository;
import com.gregs.mall.emall.dao.ProductRepository;
import com.gregs.mall.emall.dao.ProductstatusRepository;
import com.gregs.mall.emall.dao.UserRepository;
import com.gregs.mall.emall.exception.ResourceNotFoundException;
import com.gregs.mall.emall.model.Product;
import com.gregs.mall.emall.model.Product_category;
import com.gregs.mall.emall.model.Product_status;
import com.gregs.mall.emall.model.User;

@Service
public class DbInit implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductstatusRepository productstatusRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		User gregory = new User(
//				"Gregory",
//				"Ochola",
//				"gregs@yahoo.com",
//				passwordEncoder.encode("r6r5bb!!"),
//				"+254705550064", "239 SEGA", "40614", "Kenya", "Nairobi");
//		
//		userRepository.save(gregory);
//		User s1 = userRepository.findById(2)
//				.orElseThrow(()-> new ResourceNotFoundException("cannot find seller"));
//		Product_status status1 = productstatusRepository.findById(1)
//				.orElseThrow(()-> new ResourceNotFoundException("Invalid product status"));;
//		Product_category cat1 = productCategoryRepository.findById(1)
//				.orElseThrow(()-> new ResourceNotFoundException("cannot find category"));;
//		String imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7Ewl-uv7nxlssbP2AMnAmaQ0IQauwQ1mKu-wwJ05-g4ks9g1L";
//		
//		List<Product> products = new ArrayList<Product>();
//		
//		for(int i = 0; i < 15; i++) {
//			Product p1 = new Product(
//					"LG Television",
//					12,
//					2500, 
//					cat1,
//					status1,
//					s1,
//					imageUrl
//					);
//			products.add(p1);
//		}
//		
//		productRepository.saveAll(products);
	}

}
