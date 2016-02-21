DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
    `userId` varchar (255) NOT NULL,
    `name` varchar(255) NOT NULL,
    `email` varchar(255) NOT NULL,
    `gender` int NOT NULL,
    `password` varchar(255) NOT NULL,
    `role` varchar(255) NOT NULL,
    PRIMARY KEY(`userId`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Exams`;
CREATE TABLE `Exams` (
    `examId` int NOT NULL,
    `name` varchar(255) NOT NULL UNIQUE,
    `realizationDate` date NOT NULL,
    `expeditionDate` date NULL,
    `description` varchar(255) NULL,
    PRIMARY KEY(examID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Relation`;
CREATE TABLE `Relation`(
    `relationId` INT NOT NULL,
    `idUser` VARCHAR(255) NOT NULL,
    `idExam` INT NOT NULL,
    `approved` INT NOT NULL,
    `state` VARCHAR(255) NOT NULL,
    FOREIGN KEY (`idUser`) REFERENCES Users(`userId`),
    FOREIGN KEY (`idExam`) REFERENCES Exams(`examId`),
    PRIMARY KEY(relationId)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;
