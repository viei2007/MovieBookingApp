CREATE TABLE Users (
    UserID SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Theatres (
    TheatreID SERIAL PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    City VARCHAR(100) NOT NULL,
    Address TEXT NOT NULL,
    ContactEmail VARCHAR(255),
    ContactPhone VARCHAR(20),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Movies (
    MovieID SERIAL PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Language VARCHAR(50) NOT NULL,
    Genre VARCHAR(100),
    Duration INT CHECK (Duration > 0),
    ReleaseDate DATE,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Shows (
    ShowID SERIAL PRIMARY KEY,
    TheatreID BIGINT UNSIGNED,
    MovieID BIGINT UNSIGNED,
    ShowDate DATE NOT NULL,
    ShowTime TIME NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_theatre FOREIGN KEY (TheatreID) REFERENCES Theatres(TheatreID) ON DELETE CASCADE,
    CONSTRAINT fk_movie FOREIGN KEY (MovieID) REFERENCES Movies(MovieID) ON DELETE CASCADE
);


CREATE TABLE Seats (
    SeatID SERIAL PRIMARY KEY,
    TheatreID INT REFERENCES Theatres(TheatreID),
    SeatNumber VARCHAR(10) NOT NULL,
    Type VARCHAR(50) CHECK (Type IN ('Regular', 'Premium')),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE ShowSeats (
    ShowSeatID SERIAL PRIMARY KEY,
    ShowID INT REFERENCES Shows(ShowID),
    SeatID INT REFERENCES Seats(SeatID),
    Status VARCHAR(50) CHECK (Status IN ('Available', 'Booked', 'Reserved')),
    Price DECIMAL(10,2),
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Bookings (
    BookingID BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    UserID BIGINT UNSIGNED,
    ShowID BIGINT UNSIGNED,
    BookingTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10,2) NOT NULL,
    Status ENUM('Confirmed', 'Cancelled', 'Pending') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES Users(UserID) ON DELETE CASCADE,
    FOREIGN KEY (ShowID) REFERENCES Shows(ShowID) ON DELETE CASCADE
);

CREATE TABLE Payments (
    PaymentID SERIAL PRIMARY KEY,
    BookingID INT REFERENCES Bookings(BookingID),
    Amount DECIMAL(10,2) NOT NULL,
    PaymentStatus VARCHAR(50) CHECK (PaymentStatus IN ('Success', 'Failed', 'Pending')),
    PaymentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UpdatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO Users (Name, Email, Password)
VALUES
    ('Alice Johnson', 'alice@example.com', 'hashedpassword1'),
    ('Bob Smith', 'bob@example.com', 'hashedpassword2'),
    ('Charlie Brown', 'charlie@example.com', 'hashedpassword3');

INSERT INTO Theatres (Name, City, Address, ContactEmail, ContactPhone)
VALUES
    ('Theatres1', 'Delhi', 'Address-Theatres1', 'contact@regal.com', '123-456-7890'),
    ('Theatres2', 'Bangalore', 'Address-Theatres2', 'info@amctheatres.com', '987-654-3210'),
    ('Theatres3', 'Pune', 'Address-Theatres3', 'support@cineplex.com', '555-666-7777');

-- Insert data into Movies table
INSERT INTO Movies (Title, Language, Genre, Duration, ReleaseDate) VALUES
    ('Movie1', 'English', 'Sci-Fi', 148, '2010-07-16'),
    ('Movie2', 'Hindi', 'Thriller', 132, '2019-05-30'),
    ('Movie3', 'English', 'Sci-Fi', 169, '2014-11-07');

-- Insert data into Shows table
INSERT INTO Shows (TheatreID, MovieID, ShowDate, ShowTime, Price) VALUES
    (1, 1, '2025-03-10', '18:00:00', 12.50),
    (1, 3, '2025-03-11', '20:30:00', 15.00),
    (2, 2, '2025-03-12', '19:00:00', 10.00),
    (3, 1, '2025-03-13', '21:00:00', 13.00);


SELECT s.ShowID, t.Name, t.city , m.Title, s.ShowDate, s.ShowTime, s.Price
FROM Shows s
JOIN Theatres t ON s.TheatreID = t.TheatreID
JOIN Movies m ON s.MovieID = m.MovieID
Where m.MovieID="Mavie1" and t.city="abc" and showDate=sysdate();