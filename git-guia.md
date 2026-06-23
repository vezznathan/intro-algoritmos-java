# Guía de Git y GitHub
Referencia personal para no tener que buscar en internet cada vez.

---

## Conceptos clave

- **Repositorio (repo):** una carpeta rastreada por Git. Todo cambio dentro queda registrado.
- **Commit:** una "foto" del estado actual de tus archivos. Cada commit tiene un mensaje que describe qué cambiaste.
- **Push:** subir tus commits locales a GitHub.
- **Origin:** el nombre que Git le da a tu repositorio remoto (el de GitHub).
- **Main:** el nombre de la rama principal.

Git recuerda a qué repo está conectada cada carpeta — no necesitás especificarlo cada vez.
Sí necesitás estar DENTRO de la carpeta del proyecto cuando ejecutás los comandos.

---

## Configuración inicial (solo una vez en tu PC)

```bash
git config --global user.name "vezznathan"
git config --global user.email "vezznathan@gmail.com"
```

---

## Crear un repo nuevo

### Paso 1 — Crear el repo en GitHub
1. Entrá a github.com
2. Botón verde "New"
3. Ponerle nombre al repo
4. Dejarlo público
5. NO marcar ningún checkbox (sin README, sin .gitignore, sin licencia)
6. "Create repository" → GitHub te muestra el link del repo, copialo

### Paso 2 — Crear el .gitignore (para no subir archivos innecesarios)
Abrí Git Bash DENTRO de la carpeta del proyecto y ejecutá:

```bash
echo "*.class" > .gitignore
echo "*.ctxt" >> .gitignore
```

Para proyectos que no son Java, cambiá las extensiones según corresponda.
El > crea el archivo (sobreescribe si ya existe).
El >> agrega una línea al archivo existente.

### Paso 3 — Inicializar y subir

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin https://github.com/vezznathan/NOMBRE-DEL-REPO.git
git push -u origin main
```

El -u en el primer push "vincula" la rama local con la remota.
Los push siguientes solo necesitan: git push

---

## Actualizar un repo existente

Cada vez que cambiás algo y querés guardarlo en GitHub:

```bash
git add .
git commit -m "descripción de lo que cambiaste"
git push
```

### ¿Qué poner en el mensaje del commit?
Describí QUÉ cambiaste, no que "cambiaste algo":

```
✓ "Agrego clase ListaDeEstudiantes con ArrayList"
✓ "Corrijo validación de nombres en agregarEstudiante"
✓ "Agrego repOK a AnalizadorNotas"
✗ "cambios"
✗ "arregle cosas"
```

---

## Trabajar con MÚLTIPLES repos

Cada carpeta de proyecto es un repo independiente.
Git sabe a qué repo pertenece cada carpeta — no se mezclan.

Para trabajar en un repo distinto, simplemente abrí Git Bash dentro de ESA carpeta.
Una forma fácil: clic derecho dentro de la carpeta → "Open Git Bash here"

Ejemplo:
```
Inventos/                     ← repo "intro-algoritmos-java"
  AnalizadorNotas/
  prueba/

OtroProyecto/                 ← repo diferente, independiente
  MiClase.java
```

Cada uno tiene su propio historial de commits y su propio remote en GitHub.

---

## Comandos útiles

```bash
# Ver el estado actual (qué archivos cambiaron, qué está listo para commitear)
git status

# Ver el historial de commits
git log --oneline

# Ver a qué repo remoto está conectada la carpeta
git remote -v

# Verificar el contenido del .gitignore
cat .gitignore
```

---

## Cerrar y volver a abrir Git Bash

No pasa nada. Git guarda todo en la carpeta oculta `.git` dentro de tu proyecto.
Cuando volvés, abrís Git Bash en la misma carpeta y seguís normalmente.
Los commits que hiciste siguen ahí, y el remote (GitHub) sigue configurado.

---

## Errores comunes

**"LF will be replaced by CRLF"**
No es un error. Es una advertencia de Windows sobre saltos de línea. Ignorala.

**El push pide usuario y contraseña**
La contraseña es tu TOKEN de GitHub, no tu contraseña normal.
Para no tener que ingresarlo cada vez:
```bash
git config --global credential.helper store
```
La próxima vez que ingreses el token, Git lo recuerda.

**Metí mal el remote (doble barra, nombre incorrecto, etc)**
```bash
git remote remove origin
git remote add origin https://github.com/vezznathan/NOMBRE-CORRECTO.git
```

---

## Flujo completo resumido

```
REPO NUEVO:
1. Crear repo en GitHub (sin checkboxes)
2. Git Bash dentro de la carpeta
3. echo "*.class" > .gitignore
4. git init → git add . → git commit -m "Initial commit"
5. git branch -M main
6. git remote add origin URL-DEL-REPO
7. git push -u origin main

ACTUALIZAR:
1. Git Bash dentro de la carpeta del proyecto
2. git add .
3. git commit -m "descripción"
4. git push
```
