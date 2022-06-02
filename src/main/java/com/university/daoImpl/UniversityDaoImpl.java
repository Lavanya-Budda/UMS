package com.university.daoImpl;

import com.university.dao.UniversityDao;
import com.university.entity.BranchEntity;
import com.university.entity.StudentEntity;
import com.university.entity.UniversityEntity;
import com.university.entity.UserLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniversityDaoImpl implements UniversityDao {
    @Override
    public SessionFactory sessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        return factory;
    }

    @Override
    public UniversityEntity addUniversity(UniversityEntity universityEntity) {
        Session session = sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(universityEntity);
        transaction.commit();
        session.close();
        return universityEntity;
    }

    @Override
    public StudentEntity findByEmail(String email) {
        StudentEntity studentEntity = new StudentEntity();
        Session session = sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select new StudentEntity(s.id, s.sName, s.email, s.password, s.phoneNumber,s.bId) from StudentEntity as s where s.email=:email");
        query.setParameter("email",email);
        List<StudentEntity> list=query.list();
        for (StudentEntity studentEntity1:list) {
            studentEntity.setId(studentEntity1.getId());
            studentEntity.setsName(studentEntity1.getsName());
            studentEntity.setEmail(studentEntity1.getEmail());
            studentEntity.setPassword(studentEntity1.getPassword());
            studentEntity.setPhoneNumber(studentEntity1.getPhoneNumber());
            studentEntity.setbId(studentEntity1.getbId());
        }
        transaction.commit();
        session.close();
        return studentEntity;
    }

    @Override
    public void loginStatus(UserLogin userLogin) {

        Session session = sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(userLogin);
        transaction.commit();
        session.close();
    }

    @Override
    public BranchEntity findByStudentBid(Long bId) {

        BranchEntity branchEntity = new BranchEntity();
        Session session = sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("select new BranchEntity(b.id, b.branchName,b.uId) from BranchEntity as b where b.id=:id");
        query.setParameter("id",bId);
        List<BranchEntity> branchEntities = query.list();
        for (BranchEntity entity : branchEntities){
            branchEntity.setId(entity.getId());
            branchEntity.setBranchName(entity.getBranchName());
            branchEntity.setuId(entity.getuId());
        }
        return branchEntity;
    }

    @Override
    public UniversityEntity findByEmailAndId(Long uId) {
        System.out.println("Hello Dao"+uId);
        UniversityEntity universityEntity = new UniversityEntity();
        Session session = sessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query =session.createQuery("select new UniversityEntity(u.id, u.universityName, u.univercityAddress) from UniversityEntity as u where u.id=:id");
        query.setParameter("id",uId);
        List<UniversityEntity> list = query.list();
        for (UniversityEntity entity : list){
            universityEntity.setId(entity.getId());
            universityEntity.setUniversityName(entity.getUniversityName());
            universityEntity.setUnivercityAddress(entity.getUnivercityAddress());
            System.out.println(entity.getUniversityName());
        }
        return universityEntity;
    }

//    @Override
//    public StudentEntity getByEmail(String email) {
//        Query query = sessionFactory().getCurrentSession().createQuery("FROM StudentEntity where email = :email");
//        query.setParameter("email",email);
//        return (StudentEntity) query.list().get(0);
//    }
}
