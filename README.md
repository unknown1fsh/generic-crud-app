# 🚀 Generic CRUD Uygulaması | Generic CRUD Application

Dinamik ve genişletilebilir veri yönetimi için geliştirilen bu proje, farklı varlık tipleri (örneğin: PERSONEL, ÜRÜN, EĞİTİM vb.) için **generic** CRUD işlemleri sunar.  
Modern Java backend mimarisi ile sade bir HTML + Vanilla JavaScript frontend birleşmiştir.

---

## 🧩 Proje Özellikleri

- ✅ **Spring Boot** tabanlı REST API
- ✅ **Generic veri modeli** ile esnek CRUD işlemleri
- ✅ **Katmanlı mimari** (Controller, Service, Repository, DTO, Mapper)
- ✅ **MySQL** veritabanı ile veri saklama
- ✅ **Parameter Service** ile dinamik sistem ayarları yönetimi
- ✅ HTML & JavaScript tabanlı hafif frontend
- ✅ Tamamen IntelliJ IDEA CE & NetBeans 26 uyumlu

---

## ⚙️ Kurulum Adımları

### 1. Gerekli Araçlar

- Java 17+
- Maven 3.9+
- MySQL 8.x
- IntelliJ IDEA CE veya NetBeans 26

### 2. Veritabanı Hazırlığı

sql
CREATE DATABASE generic_db;

CREATE TABLE parameter (
  id INT AUTO_INCREMENT PRIMARY KEY,
  param_key VARCHAR(100) NOT NULL UNIQUE,
  param_value VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE generic_data (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  entity_type VARCHAR(100) NOT NULL,
  entity_key VARCHAR(100) NOT NULL,
  entity_value TEXT NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


### 3. `application.properties`

properties
spring.datasource.url=jdbc:mysql://localhost:3306/generic_db
spring.datasource.username=root
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


### 4. Uygulamayı Çalıştır

bash
git clone https://github.com/kullanici-adi/generic-crud-app.git
cd generic-crud-app
mvn spring-boot:run


Tarayıcıdan eriş: [http://localhost:8080/index.html](http://localhost:8080/index.html)

---

## 🖼️ Arayüz

![form](https://via.placeholder.com/600x250?text=Generic+CRUD+Form+View)
*Form: Varlık Tipi, Anahtar ve Değer girerek kayıt işlemi*

---

## 📦 Kullanım Örneği

### Veri Girişi

| Alan        | Örnek Değer |
| ----------- | ----------- |
| Varlık Tipi | PERSONEL    |
| Anahtar     | ad\_soyad   |
| Değer       | Marcus CARL |

### Sorgulama

* `GET /api/generic/PERSONEL` → `PERSONEL` tipindeki tüm verileri listeler

---

## 🧠 Kullanım Alanları

* Kullanıcı bazlı özelleştirme
* Sistemde ayar yönetimi (`parameter`)
* Key-Value konfigürasyon
* Eğitim, ürün, personel gibi tiplerin hızlı yönetimi
* Microservice yapılarına altyapı servisleri

---

## 🧑‍💻 Teknolojiler

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* MySQL
* Lombok
* HTML5 + Vanilla JavaScript

---

## 📬 İletişim

Bu proje, [Selim Sercan Çınar](https://github.com/unknown1fsh) tarafından geliştirilmiştir.
Geri bildirim, katkı ve sorular için lütfen GitHub üzerinden iletişime geçin.

---

## 📝 Lisans

MIT License © 2025
