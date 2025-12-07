-- Borrado en cascada para asegurar un estado limpio en cada ejecución (opcional pero recomendado para desarrollo)
-- SET FOREIGN_KEY_CHECKS = 0;
-- TRUNCATE TABLE falta;
-- TRUNCATE TABLE asunto_propio;
-- TRUNCATE TABLE horario;
-- TRUNCATE TABLE asignatura;
-- TRUNCATE TABLE ciclo;
-- TRUNCATE TABLE docentes;
-- TRUNCATE TABLE departamento;
-- TRUNCATE TABLE rol;
-- SET FOREIGN_KEY_CHECKS = 1;

-- 1. Insertar Roles
INSERT INTO rol (id_rol, nombre, orden) VALUES
(1, 'Profesor', 1),
(2, 'Jefe de Departamento', 0)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), orden=VALUES(orden);

-- 2. Insertar Departamentos
INSERT INTO departamento (id_departamento, nombre, codigo, telefono) VALUES
(1, 'Informática', 'IFC', '12345'),
(2, 'Lengua Castellana y Literatura', 'LCL', '54321'),
(3, 'Matemáticas', 'MAT', '67890')
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), codigo=VALUES(codigo), telefono=VALUES(telefono);

-- 3. Insertar Docentes
INSERT INTO docentes (id_docente, nombre, apellidos, email, siglas, tipo, antiguedad, posicion, departamento_id, rol_id) VALUES
(1, 'Juan', 'Pérez García', 'juan.perez@example.com', 'JPG', 'Funcionario', '2010-09-01', 1, 1, 1),
(2, 'Ana', 'López Martín', 'ana.lopez@example.com', 'ALM', 'Interino', '2018-09-01', 2, 1, 2),
(3, 'Carlos', 'Sánchez Ruiz', 'carlos.sanchez@example.com', 'CSR', 'Funcionario', '2005-09-01', 3, 2, 1),
(4, 'Laura', 'Gómez Fernández', 'laura.gomez@example.com', 'LGF', 'Prácticas', '2023-09-01', 4, 3, 1)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), apellidos=VALUES(apellidos), email=VALUES(email);

-- 4. Insertar Ciclos Formativos
INSERT INTO ciclo (id_ciclo, nombre, familia, codigo) VALUES
(1, 'Desarrollo de Aplicaciones Multiplataforma', 'Informática y Comunicaciones', 'DAM'),
(2, 'Administración de Sistemas Informáticos en Red', 'Informática y Comunicaciones', 'ASIR')
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), familia=VALUES(familia), codigo=VALUES(codigo);

-- 5. Insertar Asignaturas
INSERT INTO asignatura (id_asignatura, nombre, codigo, horas_semanales, ciclo_id) VALUES
(1, 'Sistemas Informáticos', 'SI', 6, 1),
(2, 'Bases de Datos', 'BD', 5, 1),
(3, 'Programación', 'PROG', 8, 1),
(4, 'Planificación y Administración de Redes', 'PAR', 6, 2),
(5, 'Implantación de Sistemas Operativos', 'ISO', 5, 2)
ON DUPLICATE KEY UPDATE nombre=VALUES(nombre), codigo=VALUES(codigo), horas_semanales=VALUES(horas_semanales);

-- 6. Insertar Horarios (dia: 1=Lunes, 2=Martes... | hora: 1=Primera hora, 2=Segunda...)
-- Horario para Juan Pérez (Docente 1)
INSERT INTO horario (docente_id, asignatura_id, dia, hora, aula) VALUES
(1, 1, 1, 1, 'A101'), -- Lunes a 1ª, Sistemas Informáticos en A101
(1, 2, 1, 2, 'A102'), -- Lunes a 2ª, Bases de Datos en A102
(1, 3, 2, 3, 'A101'), -- Martes a 3ª, Programación en A101
-- Horario para Ana López (Docente 2)
(2, 4, 1, 1, 'B201'), -- Lunes a 1ª, PAR en B201
(2, 5, 3, 4, 'B202'); -- Miércoles a 4ª, ISO en B202

-- 7. Insertar Asuntos Propios
INSERT INTO asunto_propio (id_docente, dia_solicitado, descripcion, fecha_tramitacion, aprobado) VALUES
(1, '2024-05-20', 'Cita médica', '2024-05-10', true),
(1, '2024-09-15', 'Asuntos personales', NULL, false),
(2, '2024-07-01', 'Mudanza', '2024-06-20', true),
(3, '2024-11-10', 'Gestiones administrativas', NULL, false);

-- 8. Insertar Faltas de Asistencia
-- Falta de Juan Pérez el Lunes a primera hora. El ID de horario es 1 (ver inserción de horarios)
INSERT INTO falta (horario_id, docente_id, fecha, anotacion, material) VALUES
(1, 1, '2024-03-04', 'El profesor faltó. Se dejó trabajo en la plataforma.', 'Leer páginas 20-25 del libro de SI.');
-- Falta de Ana López el Miércoles a cuarta hora. El ID de horario es 5
INSERT INTO falta (horario_id, docente_id, fecha, anotacion, material) VALUES
(5, 2, '2024-04-10', 'Ausencia por enfermedad.', 'Los alumnos deben empezar el proyecto final.');
