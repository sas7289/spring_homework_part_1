package com.lesson_6.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopperDao {
    SessionFactory factory;

}
