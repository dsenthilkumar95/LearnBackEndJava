package com.improve.assertj;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class BankAccountAssert extends AbstractAssert<BankAccountAssert, BankAccount> {

    // constructor for this class, but this is only used by assertThat method
    private BankAccountAssert(BankAccount bankAccount) {
        super(bankAccount, BankAccountAssert.class);
    }

    // assertThat method creates this custom assert object and returns it.
    // Only this method is static.
    // Other parameter check methods are not static,
    // since they all operate on the object created by this method and return the same object.
    public static BankAccountAssert assertThat(BankAccount bankAccount) {
        return new BankAccountAssert(bankAccount);
    }

    public BankAccountAssert hasNotNullId(){
        // this checks BankAccount object used in constructor is not null
        super.isNotNull();
        // When we super construct this class the object we have passed is saved in actual argument
        // We need to use it for all comparisons
        // Here we used Default Assertions class functionality
        Assertions.assertThat(actual.getId()).isNotNull();
        return this;
    }

    public BankAccountAssert hasId(Integer id) {
        super.isNotNull();
        Assertions.assertThat(actual.getId()).isEqualTo(id);
        return this;
    }

    public BankAccountAssert hasNullId(){
        super.isNotNull();
        Assertions.assertThat(actual.getId()).isNull();
        return this;
    }
}
