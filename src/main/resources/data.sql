CREATE TABLE routine_todo (
    id int,
    user_name varchar(255),
    description varchar(255),
    target_date DATE
);

INSERT INTO routine_todo (id, user_name, description, target_date)
VALUES (1, 'Kashif', 'Complete the Programming 3 assignments', '2022-10-10');

INSERT INTO routine_todo (id, user_name, description, target_date)
VALUES (2, 'Arslan', 'Complete the Web Development 1 assignments', '2022-10-10');
