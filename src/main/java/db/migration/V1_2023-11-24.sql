SELECT constraint_name FROM information_schema.constraint_column_usage 
WHERE table_name = 'usuario_acesso' 
AND column_name = 'acesso_id' 
and constraint_name <> 'unique_acesso_usuario'