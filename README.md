# 🚗 Parking System – Java Design Patterns Project
### מערכת ניהול חניונים המדגימה תבניות עיצוב וארכיטקטורה רב־שכבתית
Public view link:
https://www.canva.com/design/DAG5UeWV4XA/LERPyMrTR5OrR4eMCuot5g/view?utm_content=DAG5UeWV4XA&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=h901b41d23e

---

## 📘 Overview

פרויקט זה מדגים בנייה של מערכת ניהול חניונים ב־Java תוך שימוש בגישה ארכיטקטונית מסודרת ובתבניות עיצוב (Design Patterns).

המערכת מאפשרת:

- ניהול רשת חניונים  
- כניסה ויציאה של רכבים  
- ניהול כרטיסים ותשלומים  
- ניהול מנויים  
- רשימות המתנה  
- בדיקות אבטחה  
- סריקת מקומות חניה באמצעות Iterator  
- חיבור לתשלום חיצוני באמצעות Adapter  

זהו פרויקט **לימודי**, שתכליתו להמחיש תכנון נכון, מודולריות ו־SOLID — ולא מערכת חניונים אמיתית.

---

# 🏛️ System Architecture (Layers)

המערכת בנויה לפי מודל **רב־שכבתי** (Layered Architecture) עם הפרדה ברורה בין אחריויות:

+──────────────────────────────+
|        Boundary Layer        |  ← Gates, Cameras, UI
+───────────────┬──────────────+
                │
+───────────────▼──────────────+
|     Application Layer        |  ← ParkingSystemManager (Singleton)
+───────────────┬──────────────+
                │
+───────────────▼──────────────+
|          Domain Layer         |
|   • Entities                  |
|   • Domain Services (Facade)  |
|   • Payment Adapter           |
|   • Iterator                  |
+───────────────┬──────────────+
                │
+───────────────▼──────────────+
|    Infrastructure Layer       |  ← PaymentAPI, external services
+──────────────────────────────+

---

# 🧩 Design Patterns Used

## 1️⃣ Singleton – ParkingSystemManager
המנהל הראשי של המערכת, אחראי על:

- רישום חניונים  
- ניהול מנויים  
- ניהול תהליכי כניסה/יציאה  
- גישה לשירותי הדומיין  

> יוצר מופע יחיד בכל התוכנית — מקור אמת אחד למצב המערכת.

---

## 2️⃣ Facade – מחלקת Services

תבנית ה־**Facade** מרכזת את כל שירותי הדומיין לנקודת גישה אחת:

Services (Facade)
├── Payment
├── Allocation
├── Security
├── WaitingListService
├── Violation
└── Towing


ה־Facade מפשט את הגישה למודולים פנימיים  
ומבודד את Application Layer ממורכבות הדומיין.

---

## 3️⃣ Adapter – PaymentAdapter

המערכת מתחברת לשירות תשלומים חיצוני (PaymentAPI)  
באמצעות ה־Adapter המותאם לממשק פנימי (PaymentProcessor).

ה־Adapter מאפשר:

- להחליף ספק תשלומים בקלות  
- להישאר מנותקים מה־API החיצוני  
- לעמוד בעיקרון ה־DIP  

ParkingSystemManager
│
▼
PaymentProcessor (interface)
│
▼
PaymentAdapter
│
▼
PaymentAPI (external)


---

## 4️⃣ Iterator – סריקת מקומות חניה

לכל קומה יש `ParkingSpotCollection` המייצר Iterator מותאם:

ParkingSpotCollection
│ iterator()
▼
ParkingSpotIterator
│ next()
▼ hasNext()


משמש ל:

- סריקה מלאה של כל הספוטים  
- בניית ParkingScanReport  
- הסתרת מבנה הנתונים הפנימי  

---

## 5️⃣ (Optional Extension) Strategy – Pricing Policies

אם נרצה להרחיב בעתיד, ניתן להגדיר תמחור לכל חניון לפי Strategy:

PricingStrategy (interface)
├── RegularPricing
├── NightPricing
├── WeekendPricing
├── SubscriberPricing
└── DynamicPricing

> המערכת כבר ערוכה להכנסה של זה (Ticket, ChargeFee וכו’).

---

# 🚦 System Flow

## 🔹 Vehicle Entry (High-Level)
Vehicle arrives
│
▼
Security check
│
├── reject → blacklist / waiting list
│
▼
Space available?
├── no → waiting list
▼
Create ticket
▼
Allocate parking spot
▼
Open gate


---

## 🔹 Vehicle Exit (High-Level)
Vehicle leaves
│
▼
Calculate total charges
▼
PaymentProcessor.pay
│
├── fail → blacklist
▼
Mark ticket as paid
▼
Open gate


---

# 🚗 Key Entities

ParkingLot
└── Floor
└── ParkingSpotCollection
└── ParkingSpotIterator

Ticket
Vehicle
Customer / MonthlySub
Gate (Boundary)

---

# 📦 Highlights & Goals

✔ הדגמת Clean Architecture  
✔ שימוש בתבניות עיצוב באופן טבעי ומוצדק  
✔ מערכת הניתנת להרחבה בקלות  
✔ שמירה על SOLID  
✔ הפרדה בין שכבות והורדת תלות הדדית  
✔ UML + דיאגרמות תומכות  

---

# ✍ Author

**Adi Wayn**  
Ariel University  
Design Patterns – Parking System Project

---
