package com.example.shdemo.service;

import com.example.shdemo.domain.Account;
import com.example.shdemo.domain.FoodIngredient;
import com.example.shdemo.domain.ReadyMeal;
import com.example.shdemo.domain.ReadyMealDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Component
@Transactional
public class FoodCreatorImpl implements FoodCreator {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAccount(Account account) {
        account.setUserId(null);
        sessionFactory.getCurrentSession().persist(account);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public Integer addNewIngredient(FoodIngredient foodIngredient) {
        foodIngredient.setId(null);
        return (Integer) sessionFactory.getCurrentSession().save(foodIngredient);
    }

    @Override
    public Integer addNewReadMeal(ReadyMeal readyMeal) {
        readyMeal.setMealId(null);
        return (Integer) sessionFactory.getCurrentSession().save(readyMeal);
    }

    @Override
    public void updateClient(Account account) {
        sessionFactory.getCurrentSession().update(account);
    }

    @Override
    public void updateReadyMeal(ReadyMeal readyMeal) {
        sessionFactory.getCurrentSession().update(readyMeal);
    }

    @Override
    public Serializable addNewReadMealDetails(ReadyMealDetails readyMealDetails) {
        return sessionFactory.getCurrentSession().save(readyMealDetails);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        return sessionFactory.getCurrentSession().getNamedQuery("account.all")
                .list();
    }

    @Override
    public void deleteAccount(Account account) {
        account = (Account) sessionFactory.getCurrentSession().get(Account.class,
                account.getUserId());
        sessionFactory.getCurrentSession().delete(account);

    }

    @Override
    public void deleteIngredientFromReadyMealList(ReadyMealDetails readyMealDetails){
        readyMealDetails = (ReadyMealDetails) sessionFactory.getCurrentSession().get(ReadyMealDetails.class,
                readyMealDetails.getId());
        sessionFactory.getCurrentSession().delete(readyMealDetails);
    }

    @Override
    public Account findAccountByName(String name) {
        return (Account) sessionFactory.getCurrentSession().getNamedQuery("account.byName").setString("name", name).uniqueResult();
    }

    @Override
    public ReadyMeal findReadyMealByTitle(String title) {
        return (ReadyMeal) sessionFactory.getCurrentSession().getNamedQuery("readyMeal.byTitle").setString("title", title).uniqueResult();
    }

    @Override
    public List<ReadyMealDetails> findReadyMealDeatilsById(int mealId) {
        return (List<ReadyMealDetails>) sessionFactory.getCurrentSession().getNamedQuery("readyMealDeatils.byId").setInteger("mealId", mealId).list();
    }

    @Override
    public void updateReadyMealsDetails(ReadyMealDetails readyMealDetails) {
        readyMealDetails.setId(null);
        sessionFactory.getCurrentSession().persist(readyMealDetails);
        sessionFactory.getCurrentSession().flush();
    }

    @Override
    public Integer addIngrefient(FoodIngredient foodIngredient) {
        foodIngredient.setId(null);
        return (Integer) sessionFactory.getCurrentSession().save(foodIngredient);
    }

    @Override
    public ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList) {
        return null;
    }


    @Override
    public List<ReadyMeal> getAllReadyMeal() {
        return null;
    }
}
