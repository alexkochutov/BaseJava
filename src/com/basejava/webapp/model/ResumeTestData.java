package com.basejava.webapp.model;

import com.basejava.webapp.util.DateUtil;

import java.time.Month;

public class ResumeTestData {
    public static Resume fullResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.addContact(ContactType.MOBILE, "mobile");
        resume.addContact(ContactType.MAIL, "mail");
        resume.addContact(ContactType.SKYPE, "skype");
        resume.addContact(ContactType.LINKEDIN, "linkedin");
        resume.addContact(ContactType.GITHUB, "github");
        resume.addContact(ContactType.STACKOVERFLOW, "sof");
        resume.addContact(ContactType.HOMEPAGE, "homepage");

        resume.addSection(SectionType.OBJECTIVE, new StringSection("OBJECTIVE"));
        resume.addSection(SectionType.PERSONAL, new StringSection("PERSONAL"));

        ListSection achievements = new ListSection();
        achievements.addContentItem("ACHIEVEMENTS");
        resume.addSection(SectionType.ACHIEVEMENTS, achievements);

        ListSection qualifications = new ListSection();
        qualifications.addContentItem("QUALIFICATIONS");
        resume.addSection(SectionType.QUALIFICATIONS, qualifications);

        Organization work = new Organization("Organization name", "https://organization.org");
        work.addItem(new Period(DateUtil.of(2001, Month.of(1)), DateUtil.of(2002, Month.of(12)), "Job title", "Job description"));
        OrganizationSection experience = new OrganizationSection();
        experience.addContentItem(work);
        resume.addSection(SectionType.EXPERIENCE, experience);

        Organization study = new Organization("Study organization name", "https://organization.edu");
        study.addItem(new Period(DateUtil.of(2000, Month.of(1)), DateUtil.of(2000, Month.of(12)), "Title", "Description"));
        OrganizationSection education = new OrganizationSection();
        experience.addContentItem(study);
        resume.addSection(SectionType.EDUCATION, education);

        return resume;
    }

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        resume.addContact(ContactType.MOBILE, "+7(921) 855-0482");
        resume.addContact(ContactType.MAIL, "skype:grigory.kislin");
        resume.addContact(ContactType.SKYPE, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.addContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.addContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.addContact(ContactType.HOMEPAGE, "http://gkislin.ru/");

        StringSection objective = new StringSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям.");
        resume.addSection(SectionType.OBJECTIVE, objective);

        StringSection personal = new StringSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSection(SectionType.PERSONAL, personal);

        ListSection achievements = new ListSection();
        achievements.addContentItem("Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        achievements.addContentItem("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.");
        achievements.addContentItem("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.addContentItem("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.addContentItem("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.addContentItem("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.addContentItem("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        resume.addSection(SectionType.ACHIEVEMENTS, achievements);

        ListSection qualifications = new ListSection();
        qualifications.addContentItem("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.addContentItem("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.addContentItem("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.addContentItem("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        qualifications.addContentItem("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.addContentItem("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.addContentItem("Python: Django.");
        qualifications.addContentItem("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.addContentItem("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.addContentItem("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.addContentItem("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        qualifications.addContentItem("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer");
        qualifications.addContentItem("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        qualifications.addContentItem("Родной русский, английский \"upper intermediate\"");
        resume.addSection(SectionType.QUALIFICATIONS, qualifications);

        Organization o1 = new Organization("Alcatel", null);
        o1.addItem(new Period(DateUtil.of(1997, Month.of(9)), DateUtil.of(2005, Month.of(1)), "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        Organization o2 = new Organization("Siemens AG", null);
        o2.addItem(new Period(DateUtil.of(2005, Month.of(1)), DateUtil.of(2007, Month.of(2)), "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        Organization o3 = new Organization("Enkata", null);
        o3.addItem(new Period(DateUtil.of(2007, Month.of(3)), DateUtil.of(2008, Month.of(6)), "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        Organization o4 = new Organization("Yota", null);
        o4.addItem(new Period(DateUtil.of(2008, Month.of(6)), DateUtil.of(2010, Month.of(12)), "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        Organization o5 = new Organization("Luxoft (Deutsche Bank)", null);
        o5.addItem(new Period(DateUtil.of(2010, Month.of(12)), DateUtil.of(2012, Month.of(4)), "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        Organization o6 = new Organization("RIT Center", null);
        o6.addItem(new Period(DateUtil.of(2012, Month.of(4)), DateUtil.of(2014, Month.of(10)), "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        Organization o7 = new Organization("Wrike", null);
        o7.addItem(new Period(DateUtil.of(2014, Month.of(10)), DateUtil.of(2016, Month.of(1)), "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        Organization o8 = new Organization("Java Online Projects", null);
        o8.addItem(new Period(DateUtil.of(2013, Month.of(10)), null, "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        OrganizationSection experience = new OrganizationSection();
        experience.addContentItem(o1);
        experience.addContentItem(o2);
        experience.addContentItem(o3);
        experience.addContentItem(o4);
        experience.addContentItem(o5);
        experience.addContentItem(o6);
        experience.addContentItem(o7);
        experience.addContentItem(o8);
        resume.addSection(SectionType.EXPERIENCE, experience);

        Organization e1 = new Organization("Заочная физико-техническая школа при МФТИ", null);
        e1.addItem(new Period(DateUtil.of(1984, Month.of(9)), DateUtil.of(1987, Month.of(6)), "Закончил с отличием", null));
        Organization e2 = new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", null);
        e2.addItem(new Period(DateUtil.of(1987, Month.of(9)), DateUtil.of(1993, Month.of(7)), "Инженер (программист Fortran, C)", null));
        e2.addItem(new Period(DateUtil.of(1993, Month.of(9)), DateUtil.of(1996, Month.of(7)), "Аспирантура (программист С, С++)", null));
        Organization e3 = new Organization("Alcatel", null);
        e3.addItem(new Period(DateUtil.of(1997, Month.of(9)), DateUtil.of(1998, Month.of(3)), "6 месяцев обучения цифровым телефонным сетям (Москва)", null));
        Organization e4 = new Organization("Siemens AG", null);
        e4.addItem(new Period(DateUtil.of(2005, Month.of(1)), DateUtil.of(2005, Month.of(4)), "3 месяца обучения мобильным IN сетям (Берлин)", null));
        Organization e5 = new Organization("Luxoft", null);
        e5.addItem(new Period(DateUtil.of(2011, Month.of(3)), DateUtil.of(2011, Month.of(4)), "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'", null));
        Organization e6 = new Organization("Coursera", null);
        e6.addItem(new Period(DateUtil.of(2013, Month.of(3)), DateUtil.of(2013, Month.of(5)), "'Functional Programming Principles in Scala' by Martin Odersky\n", null));
        OrganizationSection education = new OrganizationSection();
        education.addContentItem(e1);
        education.addContentItem(e2);
        education.addContentItem(e3);
        education.addContentItem(e4);
        education.addContentItem(e5);
        education.addContentItem(e6);
        resume.addSection(SectionType.EDUCATION, education);

        System.out.println("Resume UUID: " + resume.getUuid());
        System.out.println("Full name : " + resume.getFullName());

        for (ContactType item : ContactType.values()) {
            System.out.println(item + " : " + resume.getContact(item));
        }

        for (SectionType item : SectionType.values()) {
            System.out.println("\n" + item + "\n" + resume.getSection(item));
        }
    }
}