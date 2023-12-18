package sit.int202.classicmodels.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodels.entities.Office;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL").getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public void close() {
        entityManager.close();
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.persist(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager = getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office office = find(newOffice.getOfficeCode());
            if (office != null) {
                entityManager.getTransaction().begin();
                entityManager.merge(newOffice);
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase() + '%';
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY");
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        return query.getResultList();
    }

    public boolean isValidString(String s) {
        if (s == null) {
            return false;
        }
        if (s.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String checkNull(HttpServletRequest request, HttpServletResponse response, String s) {
        String valid = request.getParameter(s);
        if (isValidString(valid)) {
            return valid;
        }
        return null;
    }

    public Office createOffice(HttpServletRequest request, HttpServletResponse response) {
        Office office = new Office();
        office.setOfficeCode(checkNull(request, response, "offCode"));
        office.setCity(checkNull(request, response, "city"));
        office.setPhone(checkNull(request, response, "phone"));
        office.setAddressLine1(checkNull(request, response, "addressLine1"));
        office.setAddressLine2(checkNull(request, response, "addressLine2"));
        office.setState(checkNull(request, response, "state"));
        office.setCountry(checkNull(request, response, "country"));
        office.setPostalCode(checkNull(request, response, "postalCode"));
        office.setTerritory(checkNull(request, response, "territory"));
        return office;
    }
}
