/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,1,'admin@admin.com','admin','$2a$10$0tLGVp0ORYYazS1JNfYEkOsAx9nqKAuLslgQ8O2CI/9DSKJaRYrlS','admin');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calorie_calculator`
--

DROP TABLE IF EXISTS `calorie_calculator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calorie_calculator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `body_goal` int(11) DEFAULT NULL,
  `body_type` int(11) DEFAULT NULL,
  `calories_demand` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `planned_effort` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `calorie_calculator_account_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKroqsjbkbkou2me21c6ufn4ngy` (`calorie_calculator_account_user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calorie_calculator`
--

LOCK TABLES `calorie_calculator` WRITE;
/*!40000 ALTER TABLE `calorie_calculator` DISABLE KEYS */;
/*!40000 ALTER TABLE `calorie_calculator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_ingredient`
--

DROP TABLE IF EXISTS `food_ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food_ingredient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount_carbs` double DEFAULT NULL,
  `amount_fats` double DEFAULT NULL,
  `amount_protins` double DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subcategory` int(11) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_ingredient`
--

LOCK TABLES `food_ingredient` WRITE;
/*!40000 ALTER TABLE `food_ingredient` DISABLE KEYS */;
INSERT INTO `food_ingredient` VALUES (1,72,1,12,4,'2018-08-30 22:01:55','','Makaron spaghetti ',NULL,NULL),(2,2,23,22,2,'2018-08-30 22:02:15','','Mi?so wieprzowe',NULL,NULL),(3,12,3,8,7,'2018-08-30 22:02:29','','Sos pomidorowy',NULL,NULL),(4,3,20,22,1,'2018-08-30 22:03:00','','Ser parmezan',NULL,NULL),(5,4,3,3,5,'2018-08-30 22:05:21','','Cebula',NULL,NULL),(6,72,2,12,4,'2018-08-30 22:05:38','','Ryz bialy',NULL,NULL),(7,2,9,23,2,'2018-08-30 22:05:53','','Filet z piersi indyka',NULL,NULL),(8,7,2,9,5,'2018-08-30 22:06:29','','Mix chinski - warzywa na patelnie',NULL,NULL);
/*!40000 ALTER TABLE `food_ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ready_meal`
--

DROP TABLE IF EXISTS `ready_meal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ready_meal` (
  `meal_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `ready_meal_account_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`meal_id`),
  KEY `FKccytch6e7i49k6t4vlh7egfgc` (`ready_meal_account_user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ready_meal`
--

LOCK TABLES `ready_meal` WRITE;
/*!40000 ALTER TABLE `ready_meal` DISABLE KEYS */;
INSERT INTO `ready_meal` VALUES (1,1,NULL,'','Spaghetti Bolognese',NULL,1),(2,NULL,NULL,'','Indyk po chinsku',NULL,1);
/*!40000 ALTER TABLE `ready_meal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ready_meal_details`
--

DROP TABLE IF EXISTS `ready_meal_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ready_meal_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grams_portion` double DEFAULT NULL,
  `ready_meal_details_food_ingredient_id` int(11) DEFAULT NULL,
  `ready_meal_details_ready_meal_meal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5g2yjc51bg12c5lqr8c6nsjch` (`ready_meal_details_food_ingredient_id`),
  KEY `FK7t8rsdd7dxfk8ndhxn4w9bn8p` (`ready_meal_details_ready_meal_meal_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ready_meal_details`
--

LOCK TABLES `ready_meal_details` WRITE;
/*!40000 ALTER TABLE `ready_meal_details` DISABLE KEYS */;
INSERT INTO `ready_meal_details` VALUES (1,125,1,1),(2,200,3,1),(3,50,4,1),(4,100,5,1),(5,100,6,2),(6,200,7,2),(7,250,8,2);
/*!40000 ALTER TABLE `ready_meal_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-30 22:08:50