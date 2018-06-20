-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-06-2018 a las 03:48:10
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `certificacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `descripcion`) VALUES
(1, 'Infantiles Varones'),
(2, 'Infantiles Mujeres'),
(3, 'Menores Varones'),
(4, 'Menores Mujeres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `competidor`
--

CREATE TABLE `competidor` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `idEscuela` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `fechaNac` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `competidor`
--

INSERT INTO `competidor` (`dni`, `nombre`, `apellido`, `idEscuela`, `direccion`, `sexo`, `fechaNac`) VALUES
(123, 'aa', 'ss', 1, 'dsad', 'F', '1994-05-06'),
(159, 'gg', 'dfs', 3, 'sdfsf', 'F', '1998-07-05'),
(15741, 'sa', 'sad', 3, 'd', 'F', '1994-05-03'),
(35147156, 'Maira', 'Cussit', 3, 'Maipu 757', 'F', '1990-05-09'),
(35734073, 'Martin', 'Bodello', 1, 'S Peña 373', 'M', '1991-06-13');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `disciplina`
--

CREATE TABLE `disciplina` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `disciplina`
--

INSERT INTO `disciplina` (`id`, `nombre`) VALUES
(1, '100 metros llanos'),
(2, '300 metros con posta'),
(3, '500 metros con posta'),
(4, '50 metros con vallas'),
(5, 'Salto en largo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `escuela`
--

CREATE TABLE `escuela` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `escuela`
--

INSERT INTO `escuela` (`id`, `descripcion`) VALUES
(1, 'Fasta'),
(3, 'IMI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `dniCompetidor` int(11) NOT NULL,
  `idTorneo` int(11) DEFAULT NULL,
  `idDisciplina` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `aprobada` varchar(1) DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`dniCompetidor`, `idTorneo`, `idDisciplina`, `idCategoria`, `aprobada`) VALUES
(15741, 1, 1, 1, 'N'),
(15741, 1, 1, 2, 'N'),
(15741, 1, 4, 2, 'N'),
(35147156, 1, 1, 1, 'N'),
(35147156, 1, 1, 3, 'N'),
(35147156, 1, 4, 3, 'N');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `sede` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `torneo`
--

INSERT INTO `torneo` (`id`, `fecha`, `sede`) VALUES
(1, '2018-05-08', 'Marcos juarez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `competidor`
--
ALTER TABLE `competidor`
  ADD PRIMARY KEY (`dni`),
  ADD KEY `escuela` (`idEscuela`);

--
-- Indices de la tabla `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `escuela`
--
ALTER TABLE `escuela`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`dniCompetidor`,`idDisciplina`,`idCategoria`),
  ADD KEY `categoria_idx` (`idCategoria`),
  ADD KEY `dni_idx` (`dniCompetidor`),
  ADD KEY `disciplina_idx` (`idDisciplina`),
  ADD KEY `torneo_idx` (`idTorneo`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `escuela`
--
ALTER TABLE `escuela`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `competidor`
--
ALTER TABLE `competidor`
  ADD CONSTRAINT `escuela` FOREIGN KEY (`idEscuela`) REFERENCES `escuela` (`id`);

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `competidor` FOREIGN KEY (`dniCompetidor`) REFERENCES `competidor` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `disciplina` FOREIGN KEY (`idDisciplina`) REFERENCES `disciplina` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `torneo` FOREIGN KEY (`idTorneo`) REFERENCES `torneo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
