# Advent of Code 2025 - Día 3: Escaleras y Baterías

Este proyecto contiene la solución para el [Día 3 del Advent of Code 2025](https://adventofcode.com/2025/day/3). El objetivo es calcular el voltaje máximo que se puede obtener de varios bancos de baterías, seleccionando una cantidad específica de baterías en cada banco.

## Descripción del Problema

### Parte 1

Dada una serie de bancos de baterías (cada uno representado por una secuencia de dígitos), se deben encender **exactamente dos baterías** por banco para maximizar el voltaje producido. El voltaje es el número formado por los dígitos de las baterías encendidas, respetando su orden original.

### Parte 2

El problema se escala: ahora se deben encender **exactamente doce baterías** por banco para maximizar el voltaje resultante (un número de 12 dígitos).

## Estructura del Proyecto

El código está organizado en dos paquetes principales, correspondientes a cada parte del problema:

- `software.aoc.day03.a`: Solución para la Parte 1.
- `software.aoc.day03.b`: Solución para la Parte 2.

Cada paquete sigue una estructura similar, aplicando principios de diseño de software para mantener el código limpio y mantenible.

## Principios de Diseño Aplicados

### Modularidad

El proyecto se ha dividido en módulos (clases) pequeños y cohesivos, donde cada uno encapsula una parte específica de la lógica del problema. Esto permite:

1.  **Reutilización**: Componentes como `FileInstructionReader` podrían ser reutilizados o extendidos fácilmente.
2.  **Mantenibilidad**: Los cambios en la lógica de cálculo (por ejemplo, cambiar cómo se busca el máximo) no afectan a la lectura de archivos ni a la orquestación principal.
3.  **Testabilidad**: Cada clase puede ser probada de forma aislada.

### Principio de Responsabilidad Única (SRP)

Cada clase en el proyecto tiene una única razón para cambiar, cumpliendo estrictamente con el principio SRP:

#### 1. `FileInstructionReader`

- **Responsabilidad**: Manejar la entrada de datos.
- **Detalle**: Se encarga exclusivamente de leer el archivo de entrada y transformar las líneas de texto en estructuras de datos manejables (`List<List<Integer>>`). No sabe nada sobre voltajes ni algoritmos de maximización.

#### 2. `MaxFinder`

- **Responsabilidad**: Lógica algorítmica de búsqueda.
- **Detalle**: Contiene los algoritmos puros para encontrar los valores máximos dentro de una lista o subsecuencia.
  - En la **Parte 1**, busca el dígito más alto para las decenas y luego para las unidades.
  - En la **Parte 2**, implementa un algoritmo codicioso (greedy) para encontrar la subsecuencia de 12 dígitos más grande posible.
- Esta clase no conoce el concepto de "batería" o "voltaje", solo trabaja con números y listas.

#### 3. `VoltageCalculator`

- **Responsabilidad**: Lógica de dominio.
- **Detalle**: Actúa como un puente entre el dominio del problema (calcular voltajes) y los algoritmos (`MaxFinder`). Define qué significa "calcular el voltaje más alto" en el contexto del problema, delegando la búsqueda numérica a `MaxFinder`.

#### 4. `Main`

- **Responsabilidad**: Orquestación y Punto de Entrada.
- **Detalle**: Coordina el flujo de la aplicación. Instancia el lector, obtiene los datos, invoca al calculador y acumula/imprime los resultados finales. Es el único lugar donde se unen todas las piezas.

## Cómo Ejecutar

El proyecto es una aplicación Java estándar gestionada con Maven.

1.  Asegúrate de tener el archivo de entrada en `src/main/resources/banks`.
2.  Ejecuta la clase `Main` correspondiente a la parte que deseas resolver:
    - Para la Parte 1: `software.aoc.day03.a.Main`
    - Para la Parte 2: `software.aoc.day03.b.Main`

## Resultados

- **Parte 1**: El voltaje total calculado es la suma de los máximos de 2 dígitos de cada banco.
- **Parte 2**: El voltaje total calculado es la suma de los máximos de 12 dígitos de cada banco.
