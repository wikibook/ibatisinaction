USE [master]
GO
CREATE LOGIN [jgamestore] WITH PASSWORD=N'ibatis9977', DEFAULT_DATABASE=[master], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
EXEC master..sp_addsrvrolemember @loginame = N'jgamestore', @rolename = N'dbcreator'
GO