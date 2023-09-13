# IMPACT US
I'm building an API REST for an e-commerce called by Impact Us. In this e-commerce you can have a common user and an adminstrator user. The common user can create a user,
look for products, add in a shipping cart and see your products. An Administrator can have an account, add products to clients buy, remove products and other things.
## 🛠️ Building with:
- Java
- Spring Boot
- PostgreSQL
- JPA
- Hibernate
- Spring Security
- CI (GitHub Actions)

## 📋 Requiriments
1. Java - 17
2. Maven - 3.x.x
3. MySQL
4. IDE (Intellij IDEA or Eclipse) I use Intellij. Just pick one
## Steps to setup
1. Clone the application
   ```bash
   git@github.com:EricklisCruz/ImpactUs.git
   ```
2. Create MySQL database
   ```bash
   create database impact_us
   ```
3. Change MySQL username and password

## Testing API
You can test using Postman or Insomnia. I particularly use Postman. Just pick one and start using it 
1. Create you credentials: email, password, you can be an admin or an costumer just pick one (USER_ROLE or ADMIN_ROLE)

   ![image](https://github.com/EricklisCruz/ImpactUs/assets/62524710/8971d5f5-bcaa-412f-9af6-9999efa62f98)
  
2. Login
   ![image](https://github.com/EricklisCruz/ImpactUs/assets/62524710/870d9980-e3b2-4cb5-b699-fcf7551165fd)
   
3. Copy your token. You sure are gonna need use in some endpoints. After login you are going to put some personal informations.
So, you need to select authorization, select Bearer Token and paste it:

   ![image](https://github.com/EricklisCruz/ImpactUs/assets/62524710/59f537c3-ac7c-413d-aeab-cce60a20bcd0)
   
   Then, you can select body, raw (JSON) and write your personal informations and send:
   ![image](https://github.com/EricklisCruz/ImpactUs/assets/62524710/17726bdc-881f-4577-95c5-b3ab42d696c9)

   
   
 
 

