package com.improve.assertj;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerAssertjTest {

    public BankAccount bankAccount;

    @Before
    public void setup() {
        bankAccount = new BankAccount();
    }

    @Test
    public void testIntvalues(){
        assertThat(2).isEven();
    }

    @Test
    public void testExceptionThrown() {
        assertThatThrownBy(() -> exceptionMethod())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("illegal message")
                .hasNoCause();
    }

    @Test
    public void testBankAccount() {
        BankAccountAssert.assertThat(bankAccount).hasNullId();
    }

    public void exceptionMethod() {
        throw new IllegalStateException("illegal message");
    }
}
