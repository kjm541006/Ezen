package com.jumin.springbootProject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumin.springbootProject.entity.CartEntity;
import com.jumin.springbootProject.entity.MemberEntity;
import com.jumin.springbootProject.entity.ProductEntity;
import com.jumin.springbootProject.repository.CartRepository;
import com.jumin.springbootProject.repository.MemberRepository;
import com.jumin.springbootProject.repository.ProductRepository;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, MemberRepository memberRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
    }
    
    public void addToCart(String loginId, Long productId, int quantity) {
      MemberEntity member = memberRepository.findByEmail(loginId)
              .orElseThrow(() -> new RuntimeException("Member not found with loginId: " + loginId));

      ProductEntity product = productRepository.findById(productId)
              .orElseThrow(() -> new RuntimeException("Product not found with productId: " + productId));

      // 장바구니에 추가할 수량이 재고보다 작거나 같은 경우에만 처리
      if (quantity <= product.getQuantity()) {
          CartEntity cartItem = new CartEntity(product, member, quantity);
          cartRepository.save(cartItem);
      } else {
          throw new RuntimeException("Insufficient quantity for product: " + product.getName());
      }
  }


    @Transactional
    public void removeFromCart(Long id) {
    	cartRepository.deleteById(id);
    }
    
    public List<CartEntity> getAllOrders() {
      return cartRepository.findAll();
  }
    
}
