package com.example.shdemo.service;

import com.example.shdemo.domain.Account;
import com.example.shdemo.domain.FoodIngredient;
import com.example.shdemo.domain.ReadyMeal;
import com.example.shdemo.domain.ReadyMealDetails;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public void updateClient(Account account) {
        sessionFactory.getCurrentSession().update(account);
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
    public Account findAccountByName(String name) {
        return (Account) sessionFactory.getCurrentSession().getNamedQuery("account.byName").setString("name", name).uniqueResult();
    }

    @Override
    public Integer addIngrefient(FoodIngredient foodIngredient) {
        foodIngredient.setId(null);
        return (Integer) sessionFactory.getCurrentSession().save(foodIngredient);
    }

    @Override
//    @SuppressWarnings("unchecked")
    public List<FoodIngredient> getAllFoodIngredients() {
//        return sessionFactory.getCurrentSession().getNamedQuery("foodingredient.all")
//                .list();
        return null;
    }

    @Override
    public ReadyMeal createReadyMeal(Account account, List<FoodIngredient> foodIngredientList) {
        ReadyMeal readyMeal = new ReadyMeal();

        List<ReadyMealDetails> readyMealDetails = new ArrayList<>();

        for(FoodIngredient foodIngredient : foodIngredientList){
            readyMealDetails.add(new ReadyMealDetails(50, foodIngredient));
        }

        readyMeal.setReadyMealDetailsList(readyMealDetails);
        readyMeal.setAccountByUserId(account);
        readyMeal.setTitle("Testowy posilek");

        return readyMeal;
    }

    @Override
    public List<ReadyMeal> getAllReadyMeal() {
        return null;
    }
}
