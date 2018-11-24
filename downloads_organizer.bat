@echo off

title Downloads Organizer

echo *******************************************
echo ***   Now organizing downloads folder   ***
echo *******************************************

rem For each file in your folder

cd ..\Downloads

for %%a in (".\*") do (

	rem check if the file has an extension and if it is not our script
	if "%%~xa" NEQ ""  if "%%~dpxa" NEQ "%~dpx0" (
		
		rem check if extension folder exists, if not it is created
		if not exist "%%~xa" mkdir "%%~xa"
		rem Move the file to directory
		move "%%a" "%%~dpa%%~xa\"
	)
)