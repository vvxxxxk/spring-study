package com.core.hello.scope;

import jakarta.inject.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest {

    @Test
    void prototypeFind() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);
        ProtoTypeBean protoTypeBean1 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean1.addCount();
        assertThat(protoTypeBean1.getCount()).isEqualTo(1);

        ProtoTypeBean protoTypeBean2 = ac.getBean(ProtoTypeBean.class);
        protoTypeBean2.addCount();
        assertThat(protoTypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClinetUsePrototype() {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClinetBean.class, ProtoTypeBean.class);
        ClinetBean clinetBean1 = ac.getBean(ClinetBean.class);
        int count1 = clinetBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClinetBean clinetBean2 = ac.getBean(ClinetBean.class);
        int count2 = clinetBean2.logic();
        // assertThat(count2).isEqualTo(2);
        assertThat(count2).isEqualTo(1);
    }

    @Scope("singleton")
    static class ClinetBean {

        private final Provider<ProtoTypeBean> protoTypeBeanProvider;

        @Autowired
        public ClinetBean(Provider<ProtoTypeBean> protoTypeBeanProvider) {
            this.protoTypeBeanProvider = protoTypeBeanProvider;
        }

        public int logic() {
            ProtoTypeBean protoTypeBean = protoTypeBeanProvider.get();
            protoTypeBean.addCount();
            return protoTypeBean.getCount();
        }
    }


    @Scope("prototype")
    static class ProtoTypeBean {

        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
