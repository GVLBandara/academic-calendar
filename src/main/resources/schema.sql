CREATE TABLE IF NOT EXISTS task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(225) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    task_type VARCHAR(50) NOT NULL,
    date TIMESTAMP NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255)
);

-- INSERT INTO task (title, desc, status, task_type, date, date_created, date_updated, url)
-- VALUES
--     ('Complete Project Proposal', 'Draft and submit the project proposal for review', 'IN_PROGRESS', 'ASSESMENT', '2023-10-12 14:00:00', '2023-10-11 09:30:00', NULL, 'https://example.com/proposal'),
--     ('Meeting with Client', 'Discuss project requirements and timelines', 'SCHEDULED', 'EXAM', '2023-10-14 10:30:00', '2023-10-11 11:15:00', NULL, NULL),
--     ('Research Competitors', 'Analyze and document competitor products', 'IN_PROGRESS', 'PRESENTATION', '2023-10-13 16:45:00', '2023-10-11 14:20:00', NULL, NULL),
--     ('Update Website Content', 'Refresh website content and images', 'COMPLETE', 'VIVA', '2023-10-11 11:00:00', '2023-10-11 10:30:00', '2023-10-11 14:10:00', 'https://example.com/updates'),
--     ('Monthly Report', 'Compile and send monthly progress report to stakeholders', 'COMPLETE', 'ASSESMENT', '2023-10-15 15:30:00', '2023-10-11 15:00:00', NULL, NULL);
