package io.probedock.demo.junit;

/**
 * Simple calculator class with basic operations
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class Calculator {
    public int add(int left, int right) {
        return left + right;
    }

    public int sub(int left, int right) {
        return left - right;
    }

    public int mul(int left, int right) {
        return left * right;
    }

    public int div(int left, int right) {
        if (right == 0) {
            throw new IllegalArgumentException("The right operand must be different from 0.");
        }

        return left / right;
    }
}
