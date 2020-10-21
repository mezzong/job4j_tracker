package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User element : users.keySet()) {
            if (passport.equals(element.getPassport())) {
                result = element;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        List<Account> accountList = users.get(user);
        if (accountList == null) {
            return null;
        }
        for (Account element : accountList) {
            if (requisite.equals(element.getRequisite())) {
                account = element;
                break;
            }
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rls = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null) {
            return rls;
        }
        if ((srcAccount.getBalance() - amount) < 0) {
            return rls;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return rls;
    }
}

