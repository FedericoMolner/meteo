# 🌤️ Meteo App – Previsioni Giornaliere per le Città Italiane

Applicazione web realizzata in Java + Spring Boot per visualizzare le **temperature massime giornaliere delle ultime 2 settimane** di diverse città italiane.  
I dati sono forniti in tempo reale da [Open-Meteo](https://open-meteo.com/).

---

## ⚙️ Requisiti

- [Docker](https://www.docker.com/) installato e funzionante  
- Java e Maven **non richiesti** (tutto gira in container)

---

## 🚀 Avvio dell’applicazione

### 1️⃣ Clona il progetto

```bash
git clone https://github.com/tuo-utente/meteo-app.git
cd meteo-app
```

### 2️⃣ Avvia l’app con Docker Compose

```bash
docker-compose up --build
```

### 3️⃣ Apri il browser

[http://localhost:8080](http://localhost:8080)

---

## 🗂️ Struttura del progetto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── controller, dto, service...
│   └── resources/
│       ├── templates/
│       │   └── meteo.html
│       └── application.properties
```

---

## 📝 Note

- Accesso root (`/`) reindirizza automaticamente a `/meteo`
- Il progetto non ha database
- Puoi modificare le città e le coordinate direttamente in `MeteoController.java`
