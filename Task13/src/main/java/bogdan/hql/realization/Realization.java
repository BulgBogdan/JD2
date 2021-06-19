package bogdan.hql.realization;

import bogdan.hql.entity.Seller;
import bogdan.hql.entity.Shop;
import bogdan.hql.service.SellerDAO;
import bogdan.hql.service.SellerDAOImpl;
import bogdan.hql.service.ShopDAO;
import bogdan.hql.service.ShopDAOImpl;
import bogdan.hql.util.HibernateUtil;
import org.eclipse.persistence.exceptions.EclipseLinkException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class Realization {

    ShopDAO shopDAO = new ShopDAOImpl();
    SellerDAO sellerDAO = new SellerDAOImpl();

    public void createShopAndSellers(int count) {
        for (int i = 0; i < count; i++) {
            shopDAO.create(ShopUtil.getShop());
            List<Shop> shops = shopDAO.getAll();
            for (int j = 0; j < 3; j++) {
                sellerDAO.create(SellerUtil.getSeller(shops));
            }
        }
    }

    public void showShopsAndSellers() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        List<Seller> sellers = null;
        List<Shop> shops = null;
        try {
            entityManager.getTransaction().begin();
            sellers = entityManager.createQuery("from Seller s").getResultList();
            shops = entityManager.createQuery("from Shop s").getResultList();
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
        sellers.forEach(System.out::println);
        shops.forEach(System.out::println);
    }

    public void showMoreThousands() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager
                    .createQuery("select s.firstName, s.lastName " +
                            "from Seller s join s.shop sh where sh.profit > 1000");
            query.getResultList().forEach(sellers -> {
                Object[] seller = (Object[]) sellers;
                System.out.println("Name: " + seller[0] + " Last Name: " + seller[1]);
            });
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    public void showSellersWithDate() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager
                    .createQuery("select s.lastName, s.salary " +
                            "from Seller s join s.shop sh where sh.createdDate > '2020-06-06'");
            query.getResultList().forEach(sellers -> {
                Object[] seller = (Object[]) sellers;
                System.out.println("Last Name: " + seller[0] + " Salary: " + seller[1]);
            });
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }

    public void showShopssWithLastName() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager
                    .createQuery("select sh.name, s.lastName from Shop sh join sh.sellers s " +
                            "where s.lastName like 'Ivanov' " +
                            "or s.lastName like 'Fedorov' " +
                            "or s.lastName like 'Semenov' ");
            query.getResultList().forEach(shops -> {
                Object[] shop = (Object[]) shops;
                System.out.println("Shop Name: " + shop[0] + " LastName: " + shop[1]);
            });
            entityManager.getTransaction().commit();
        } catch (EclipseLinkException ex) {
            entityManager.getTransaction().rollback();
        } finally {
            if (Objects.nonNull(entityManager)) {
                entityManager.close();
            }
        }
    }


}
