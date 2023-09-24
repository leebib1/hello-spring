package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository{ //db가 지정됐으면 인터페이스 상속 받아서 그대로 구현

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql="INSERT INTO MEMBER(NAME) VALUES(?)";

        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        try{
            conn= dataSource.getConnection();
            pstmt=conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //key 반환
            pstmt.setString(1, member.getName()); //첫번째 ?(위치홀더)에 지정한 값 대입
            pstmt.executeUpdate(); //쿼리문 실행 시점
            rs= pstmt.getGeneratedKeys();

            if(rs.next()){
                member.setId(rs.getLong(1));
            }else{
                throw new SQLException("id 조회 실패");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //사용한 것들 역순으로 닫아주기
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
