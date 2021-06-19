package cn.xdevops.designpatterns.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Singleton Test ")
class SingletonTest {

    @Test
    @DisplayName("Should get unique instance with UnsafeSingleton ")
    void shouldGetUniqueInstanceWithUnsafeSingleton() {
        UnsafeSingleton instance1 = UnsafeSingleton.getInstance();
        UnsafeSingleton instance2 = UnsafeSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("Should get unique instance with SynchronizedSingleton ")
    void shouldGetUniqueInstanceWithSynchronizedSingleton() {
        SynchronizedSingleton instance1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton instance2 = SynchronizedSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("Should get unique instance with InitializedSingleton ")
    void shouldGetUniqueInstanceWithInitializedSingleton() {
        InitializedSingleton instance1 = InitializedSingleton.getInstance();
        InitializedSingleton instance2 = InitializedSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

    @Test
    @DisplayName("Should get unique instance with DoubleCheckedLockingSingleton ")
    void shouldGetUniqueInstanceWithDoubleCheckedLockingSingleton() {
        DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton instance2 = DoubleCheckedLockingSingleton.getInstance();
        assertEquals(instance1, instance2);
    }

   // TODO Unit test for multi-threaded code



}