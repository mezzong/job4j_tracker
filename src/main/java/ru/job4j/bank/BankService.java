package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
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
                break;
            }
        }
        return result;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            System.out.println("User not found");
            return null;
        }
        Account account = null;
        List<Account> accountList = users.get(user);
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
        if (srcAccount == null || destAccount == null || (srcAccount.getBalance() - amount) < 0) {
            return rls;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        rls = true;
        return rls;
    }

    public static void main(String[] args) {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount("ffd", new Account("5546", 150D));
    }
}

