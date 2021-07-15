USE [master]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

DROP TABLE [dbo].[address]
    GO

DROP TABLE [dbo].[customer]
    GO

CREATE TABLE [dbo].[customer](
    [id] [uniqueidentifier] NULL,
    [db_id] bigint IDENTITY(1,1) NOT NULL PRIMARY KEY CLUSTERED,
    [first_name] nvarchar(10) NULL,
    [last_name] nvarchar(10) NULL
    ) ON [PRIMARY]
    GO

CREATE TABLE [dbo].[address](
    [id] [uniqueidentifier] NULL,
    [db_id] bigint IDENTITY(1,1) NOT NULL PRIMARY KEY CLUSTERED,
    customer_db_id bigint NOT NULL,
    [street] nvarchar(100) NULL,
    [zip] nchar(10) NULL
    ) ON [PRIMARY]
    GO

ALTER TABLE [dbo].[address]
    ADD CONSTRAINT FK_customer_address FOREIGN KEY (customer_db_id)
    REFERENCES [dbo].[customer] ([db_id])
    GO