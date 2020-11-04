package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport).orElse(null);
        if (user == null) {
            System.out.println("User not found");
            return;
        }
        List<Account> accountList = users.get(user);
        if (!accountList.contains(account)) {
            accountList.add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.isPresent() ?  users.get(user.get())
                .stream()
                .filter(account -> account.getRequisite().equals(requisite))
                .findFirst()
        : Optional.empty();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rls = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite).orElse(null);
        Account destAccount = findByRequisite(destPassport, destRequisite).orElse(null);
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

