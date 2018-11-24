@echo off
REM
REM Created by Joseph Walker, December 2017
REM Email jwalker.depaul@gmail.com with any suggestions

title Downloads Folder Cleaner

echo **********************************
echo ***   Now removing documents   ***
echo **********************************

	echo Navigating to downloads folder
	cd C:\Users\cad6025\Downloads

	echo Deleting all content
	del /F /S /Q .

	echo cleanup completed
	pause