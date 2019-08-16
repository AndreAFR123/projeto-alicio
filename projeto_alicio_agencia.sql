CREATE TABLE `agencia` (
  `idAgencia` int(11) NOT NULL AUTO_INCREMENT,
  `nm_agencia` varchar(45) NOT NULL,
  `num_agencia` int(11) NOT NULL,
  PRIMARY KEY (`idAgencia`),
  UNIQUE KEY `idAgencia_UNIQUE` (`idAgencia`)
)