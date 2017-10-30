package com.secondhandcar.platform.service;

/**
 * Created by xiet on 2017/10/25.
 */
public class TestGetAnnotation {
    public static void main(String[] args) {
        try {
            Class componentClass = Class.forName("com.secondhandcar.platform.service.UpperCaseComponent");
            if(componentClass.isAnnotationPresent(Component.class)) {
                Component component = (Component)componentClass.getAnnotation(Component.class);
                String identifier = component.identifier();
                System.out.println(String.format("Identifier for "
                        + "com.secondhandcar.platform.service.UpperCaseComponent is ' %s '", identifier));
            } else {
                System.out.println("com.secondhandcar.platform.service.UpperCaseComponent is not annotated by"
                        + " com.secondhandcar.platform.service.Component");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
