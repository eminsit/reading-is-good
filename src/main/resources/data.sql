INSERT INTO BOOKS (title, author_name, count, price) VALUES
  ('Sefiller', 'Victor Hugop', 21, 10),
  ('Vadideki Zambak', 'Maksim Gorki ', 32, 20),
  ('Beyaz Diş', 'Jack London ', 4, 30),
  ('Akdeniz', 'Panait Istrati', 13, 40),
  ('Goriot Baba', 'Charles Dıckens ', 2, 50)
  ;


INSERT INTO CUSTOMERS (name, email) VALUES
('Can Bonomo', 'can@gmail.com'),
('Meg Myers', 'myers@gmail.com')
;



INSERT INTO ORDERS (status, total_amount, customer_id) VALUES
(1, 32.32,1),
(1, 343.3,1)
;



INSERT INTO ORDER_ITEMS (order_id, book_id, book_count) VALUES
(1l, 1l, 3),
(1l, 2l, 4),
(2l, 1l, 1)
;


