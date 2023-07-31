-- Write unique indexes bottom

-- CREATE UNIQUE INDEX IF NOT EXISTS uk_signature_user_id ON signature (user_id) WHERE deleted = false;
-- CREATE UNIQUE INDEX IF NOT EXISTS uk_module_name ON module (name) WHERE deleted = false;
-- CREATE UNIQUE INDEX IF NOT EXISTS uk_group_name ON groups (name) WHERE deleted = false;
-- CREATE UNIQUE INDEX IF NOT EXISTS uk_room_name ON room (name) WHERE deleted = false;
-- CREATE UNIQUE INDEX IF NOT EXISTS uk_attendance ON attendance (student_id, lesson_id) WHERE deleted = false;
-- CREATE UNIQUE INDEX IF NOT EXISTS uk_semester ON semester (level, type, year) WHERE deleted = false;