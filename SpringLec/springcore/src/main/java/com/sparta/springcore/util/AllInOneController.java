//package com.sparta.springcore;
//
//import com.sparta.springcore.Product;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
////이제 스프링 시작 -> 컨트롤러 단만 바꾼 것
//
//
//@RestController // JSON으로 데이터를 주고받음을 선언합니다.
//public class AllInOneController {
//
//    // 등록된 전체 상품 목록 조회
//    @GetMapping("/api/products")
//    public List<Product> getProducts() throws SQLException {
////        ArrayList<Product> products = new ArrayList<>();
////        // DB 연결
////        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
////        // DB Query 작성 및 실행
////        Statement stmt = connection.createStatement();
////        ResultSet rs = stmt.executeQuery("select * from product");
////        // DB Query 결과를 상품 객체 리스트로 변환
////        while (rs.next()) {
////            Product product = new Product();
////            product.setId(rs.getLong("id"));
////            product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
////            product.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
////            product.setImage(rs.getString("image"));
////            product.setLink(rs.getString("link"));
////            product.setLprice(rs.getInt("lprice"));
////            product.setMyprice(rs.getInt("myprice"));
////            product.setTitle(rs.getString("title"));
////            products.add(product);
////        }
////        // DB 연결 해제
////        rs.close();
////        connection.close();
////        // 응답 보내기
////        return products;
//
////        위 코드는 db 호출까지 포함. 아래코드는 리포지터리 호출하는 것을 서비스로 보냄
//
//        ProductService productService = new ProductService();
//        List<Product> products = productService.getProducts();
//        return products;
//    }
//
//    // 신규 상품 등록
//    @PostMapping("/api/products")
//    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
////        // 요청받은 DTO 로 DB에 저장할 객체 만들기
////        Product product = new Product(requestDto);
////        LocalDateTime now = LocalDateTime.now();
////        product.setCreatedAt(now);
////        product.setModifiedAt(now);
////        // DB 연결
////        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
////        // DB Query 작성
////        PreparedStatement ps = connection.prepareStatement("select max(id) as id from product");
////        ResultSet rs = ps.executeQuery();
////        if (rs.next()) {
////            // product id 설정 = product 테이블의 마지막 id + 1
////            product.setId(rs.getLong("id") + 1);
////        } else {
////            throw new SQLException("product 테이블의 마지막 id 값을 찾아오지 못했습니다.");
////        }
////        ps = connection.prepareStatement("insert into product(id, title, image, link, lprice, myprice, created_at, modified_at) values(?, ?, ?, ?, ?, ?, ?, ?)");
////        ps.setLong(1, product.getId());
////        ps.setString(2, product.getTitle());
////        ps.setString(3, product.getImage());
////        ps.setString(4, product.getLink());
////        ps.setInt(5, product.getLprice());
////        ps.setInt(6, product.getMyprice());
////        ps.setString(7, product.getCreatedAt().toString());
////        ps.setString(8, product.getModifiedAt().toString());
////        // DB Query 실행
////        ps.executeUpdate();
////        // DB 연결 해제
////        ps.close();
////        connection.close();
////        // 응답 보내기
//        ProductService productService = new ProductService();
//        Product product = productService.createProduct(requestDto);
//        return product; //api 바디쪽에 json으로 내려주게 됨
//    }
//
//    // 설정 가격 변경
//    @PutMapping("/api/products/{id}")
//    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {//유니크한 값과 dto가 들어있음
////        Product product = new Product();
////        // DB 연결
////        Connection connection = DriverManager.getConnection("jdbc:h2:mem:springcoredb", "sa", "");
////        // DB Query 작성
////        PreparedStatement ps = connection.prepareStatement("select * from product where id = ?");
////        ps.setLong(1, id);
////        // DB Query 실행
////        ResultSet rs = ps.executeQuery();
////        if (rs.next()) {
////            product.setId(rs.getLong("id"));
////            product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
////            product.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
////            product.setImage(rs.getString("image"));
////            product.setLink(rs.getString("link"));
////            product.setLprice(rs.getInt("lprice"));
////            product.setMyprice(rs.getInt("myprice"));
////            product.setTitle(rs.getString("title"));
////        } else {
////            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
////        }
////        // DB Query 작성
////        ps = connection.prepareStatement("update product set myprice = ?, modified_at = ? where id = ?");
////        ps.setInt(1, requestDto.getMyprice());
////        ps.setString(2, LocalDateTime.now().toString());
////        ps.setLong(3, product.getId());
////        // DB Query 실행
////        ps.executeUpdate();
////        // DB 연결 해제
////        rs.close();
////        ps.close();
////        connection.close();
////        // 응답 보내기 (업데이트된 상품 id)
//        ProductService productService = new ProductService();
//        Product product = productService.updateProduct(id, requestDto);
//        return product.getId();
//
//    }
//}