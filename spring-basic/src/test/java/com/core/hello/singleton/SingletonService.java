package com.core.hello.singleton;

public class SingletonService {

    // private static으로 자기 자신을 내부에 선언
    private static final SingletonService instance = new SingletonService();

    // private 생성자를 통해 다른 곳에서 new를 통해 인스턴스를 생성할 수 없도록 함
    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }
}
