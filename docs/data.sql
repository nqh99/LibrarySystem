INSERT INTO 
	Library (name, location, create_time, update_time)
VALUES
	('Oxford Library', '165, Lincoln, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Quang Trung Library', '165, Quang Trung, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Tran Quang Dieu Library', '165, Tran Quang Dieu, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Tran Quoc Tuan Library', '165, Tran Quoc Tuan, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Cach Mang Thang 8 Library', '165, Cach Mang Thang 8, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Ngo Quyen Library', '165, Ngo Quyen, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Nguyen Du Library', '165, Nguyen Du, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Nguyen Trai Library', '165, Nguyen Trai, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Dinh Bo Linh Library', '165, Dinh Bo Linh, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Tu Hai Library', '165, Tu Hai, 14 ward, Go Vap District', '2012-04-02', '2012-09-02'),
	('Tho Bay Mau Library', '165, Tho Bay Mau, 14 ward, Go Vap District', '2012-04-02', '2012-09-02');
	

INSERT INTO 
	Renters (name, email, phone_number, create_time, update_time, library_id)
VALUES
	('Nguyen Van A', 'a@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 11),
	('Nguyen Van B', 'b@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 10),
	('Nguyen Van C', 'c@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 11),
	('Nguyen Van D', 'd@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 9),
	('Nguyen Van E', 'e@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 8),
	('Nguyen Van F', 'f@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 7),
	('Nguyen Van G', 'g@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 7),
	('Nguyen Van H', 'h@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 7),
	('Nguyen Van J', 'j@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 1),
	('Nguyen Van K', 'k@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 2),
	('Nguyen Van L', 'l@gmail.com', '0123456789', '2012-04-02', '2012-09-02', 3);
	
	
INSERT INTO 
	Books (author, name, create_time, update_time, library_id, renter_id)
VALUES
	('Cao Ba A', 'Con duong A', '2012-04-02', '2012-09-02', 11, 4),
	('Cao Ba B', 'Con duong B', '2012-04-02', '2012-09-02', 11, 5),
	('Cao Ba C', 'Con duong C', '2012-04-02', '2012-09-02', 11, 2),
	('Cao Ba D', 'Con duong D', '2012-04-02', '2012-09-02', 11, 10),
	('Cao Ba E', 'Con duong E', '2012-04-02', '2012-09-02', 7, 7),
	('Cao Ba F', 'Con duong F', '2012-04-02', '2012-09-02', 7, 6),
	('Cao Ba G', 'Con duong G', '2012-04-02', '2012-09-02', 7, 6),
	('Cao Ba H', 'Con duong H', '2012-04-02', '2012-09-02', 10, 6),
	('Cao Ba J', 'Con duong J', '2012-04-02', '2012-09-02', 10, 11),
	('Cao Ba K', 'Con duong K', '2012-04-02', '2012-09-02', 1, 3),
	('Cao Ba L', 'Con duong L', '2012-04-02', '2012-09-02', 2, 9);	
