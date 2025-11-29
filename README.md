# 🚀 Generic CRUD Uygulaması

> Dinamik ve genişletilebilir veri yönetimi için geliştirilmiş Spring Boot tabanlı Generic CRUD uygulaması

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 📖 Hakkında

Bu proje, farklı varlık tipleri (PERSONEL, ÜRÜN, EĞİTİM, HİZMET vb.) için **generic** CRUD işlemleri sunan esnek bir veri yönetim sistemidir. Modern Java backend mimarisi ile responsive HTML + Vanilla JavaScript frontend birleşmiştir.

### ✨ Özellikler

- ✅ **Tam CRUD İşlemleri**: Create, Read, Update, Delete
- ✅ **Gelişmiş Arama**: Varlık tipi, anahtar ve değer bazlı filtreleme
- ✅ **Sistem Parametreleri**: Key-Value tabanlı dinamik konfigürasyon
- ✅ **Specification Pattern**: Dinamik JPA sorguları
- ✅ **Validation**: Jakarta Validation ile veri doğrulama
- ✅ **Exception Handling**: Merkezi hata yönetimi
- ✅ **Modern UI**: Responsive tasarım, toast bildirimleri

---

## 🛠️ Teknoloji Stack

| Kategori | Teknolojiler |
|----------|-------------|
| **Backend** | Java 17, Spring Boot 3.5.0, Spring Data JPA, MySQL 8.0 |
| **Frontend** | HTML5, CSS3, Vanilla JavaScript (ES6+) |
| **Araçlar** | Maven 3.9+, Lombok, Jakarta Validation |

---

## 🚀 Hızlı Başlangıç

### Gereksinimler

- ☕ Java 17+
- 🗄️ MySQL 8.0+
- 📦 Maven 3.9+

### Kurulum Adımları

#### 1️⃣ Veritabanını Oluşturun

```sql
CREATE DATABASE generic_db;
```

**Windows PowerShell:**
```powershell
& "C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe" -u root -p12345 -e "CREATE DATABASE IF NOT EXISTS generic_db;"
```

#### 2️⃣ Yapılandırmayı Kontrol Edin

`src/main/resources/application.properties` dosyasında MySQL bilgilerinizi kontrol edin:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/generic_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=12345
```

#### 3️⃣ Projeyi Çalıştırın

```bash
# Projeyi derleyin
mvn clean install -DskipTests

# Uygulamayı başlatın
mvn spring-boot:run
```

#### 4️⃣ Uygulamaya Erişin

🌐 **Web Arayüzü:** [http://localhost:8080/index.html](http://localhost:8080/index.html)

📡 **API Endpoint:** [http://localhost:8080/api/generic](http://localhost:8080/api/generic)

---

## 📚 API Dokümantasyonu

### Generic Data Endpoints

| Method | Endpoint | Açıklama |
|--------|----------|----------|
| `GET` | `/api/generic` | Tüm kayıtları getir |
| `GET` | `/api/generic/id/{id}` | ID ile kayıt getir |
| `GET` | `/api/generic/{type}` | Varlık tipine göre getir |
| `GET` | `/api/generic/search?entityType=&key=&value=` | Gelişmiş arama |
| `POST` | `/api/generic` | Yeni kayıt ekle |
| `PUT` | `/api/generic/{id}` | Kayıt güncelle |
| `DELETE` | `/api/generic/{id}` | Kayıt sil |

### Parameter Endpoints

| Method | Endpoint | Açıklama |
|--------|----------|----------|
| `GET` | `/api/parameters` | Tüm parametreleri getir |
| `GET` | `/api/parameters/{id}` | ID ile parametre getir |
| `GET` | `/api/parameters/key/{key}` | Anahtara göre getir |
| `GET` | `/api/parameters/value/{key}` | Parametre değerini getir |
| `POST` | `/api/parameters` | Yeni parametre ekle |
| `PUT` | `/api/parameters/{id}` | Parametre güncelle |
| `DELETE` | `/api/parameters/{id}` | Parametre sil |

### Örnek Kullanım

**Yeni Kayıt Ekle:**
```bash
curl -X POST http://localhost:8080/api/generic \
  -H "Content-Type: application/json" \
  -d '{
    "entityType": "PERSONEL",
    "entityKey": "ad_soyad",
    "entityValue": "Ahmet Yılmaz"
  }'
```

**Arama Yap:**
```bash
curl "http://localhost:8080/api/generic/search?entityType=PERSONEL&key=ad"
```

---

## 📁 Proje Yapısı

```
generic-crud-app/
├── src/main/java/com/smartworkflow/genericcrudapp/
│   ├── controller/          # REST API endpoint'leri
│   ├── service/            # İş mantığı
│   ├── repository/         # Veritabanı erişimi
│   ├── entity/             # JPA entity'leri
│   ├── dto/                # Veri transfer nesneleri
│   ├── mapper/             # Entity-DTO dönüşümleri
│   ├── exception/          # Hata yönetimi
│   └── specification/      # JPA Specification'ları
├── src/main/resources/
│   ├── application.properties  # Uygulama yapılandırması
│   └── static/
│       └── index.html          # Frontend sayfası
└── pom.xml                    # Maven bağımlılıkları
```

---

## 🎯 Kullanım Senaryoları

### Senaryo 1: Personel Bilgileri
```
Varlık Tipi: PERSONEL
Anahtar-Değer:
  - ad_soyad: "Ahmet Yılmaz"
  - departman: "Bilgi İşlem"
  - maas: "15000"
```

### Senaryo 2: Ürün Kataloğu
```
Varlık Tipi: URUN
Anahtar-Değer:
  - urun_adi: "Laptop"
  - fiyat: "25000"
  - stok: "50"
```

### Senaryo 3: Sistem Ayarları
```
Parametreler:
  - app.name: "Generic CRUD App"
  - max.users: "100"
```

---

## 🐛 Sorun Giderme

### Veritabanı Bağlantı Hatası
```bash
# MySQL servisini kontrol edin
Get-Service MySQL80

# Servisi başlatın (gerekirse)
Start-Service MySQL80
```

### Port Kullanımda
`application.properties` dosyasında port değiştirin:
```properties
server.port=8081
```

### Bağımlılık Hatası
```bash
mvn clean install -U
```

---

## 📝 Geliştirme

### Projeyi Geliştirme Modunda Çalıştırma
```bash
mvn spring-boot:run
```

### Test Çalıştırma
```bash
mvn test
```

### JAR Oluşturma
```bash
mvn clean package
java -jar target/generic-crud-app-0.0.1-SNAPSHOT.jar
```

---

## 🤝 Katkıda Bulunma

1. Fork edin
2. Feature branch oluşturun (`git checkout -b feature/amazing-feature`)
3. Commit edin (`git commit -m 'Add amazing feature'`)
4. Push edin (`git push origin feature/amazing-feature`)
5. Pull Request açın

---

## 📄 Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için `LICENSE` dosyasına bakın.

---

## 👨‍💻 Geliştirici

**Selim Sercan Çınar**

- GitHub: [@unknown1fsh](https://github.com/unknown1fsh)

---

## ⭐ Destek

Bu projeyi beğendiyseniz yıldız vermeyi unutmayın! ⭐

---

**Not:** Sorularınız için GitHub Issues kullanabilirsiniz.
