class Student:
    def __init__(self, name, c_grade, cpp_grade, java_grade):
        self.name = name
        self.c_grade = c_grade
        self.cpp_grade = cpp_grade
        self.java_grade = java_grade

    def calculate_average(self):
        return (self.c_grade + self.cpp_grade + self.java_grade) / 3

    def determine_grade(self, score):
        if score >= 90:
            return 'A+'
        elif score >= 80:
            return 'A'
        elif score >= 70:
            return 'B+'
        elif score >= 60:
            return 'B'
        elif score >= 50:
            return 'C+'
        elif score >= 40:
            return 'C'
        else:
            return 'F'

    def get_grades(self):
        return {
            'C': self.determine_grade(self.c_grade),
            'C++': self.determine_grade(self.cpp_grade),
            'Java': self.determine_grade(self.java_grade),
            'Average': self.determine_grade(self.calculate_average())
        }

class GradeTracker:
    def __init__(self):
        self.students = []

    def add_student(self, name, c_grade, cpp_grade, java_grade):
        student = Student(name, c_grade, cpp_grade, java_grade)
        self.students.append(student)

    def calculate_highest(self):
        highest_score = {
            'C': max(self.students, key=lambda student: student.c_grade).c_grade,
            'C++': max(self.students, key=lambda student: student.cpp_grade).cpp_grade,
            'Java': max(self.students, key=lambda student: student.java_grade).java_grade
        }
        return highest_score

    def calculate_lowest(self):
        lowest_score = {
            'C': min(self.students, key=lambda student: student.c_grade).c_grade,
            'C++': min(self.students, key=lambda student: student.cpp_grade).cpp_grade,
            'Java': min(self.students, key=lambda student: student.java_grade).java_grade
        }
        return lowest_score

    def calculate_class_average(self):
        avg_scores = {
            'C': sum(student.c_grade for student in self.students) / len(self.students),
            'C++': sum(student.cpp_grade for student in self.students) / len(self.students),
            'Java': sum(student.java_grade for student in self.students) / len(self.students)
        }
        return avg_scores

    def display_student_grades(self):
        for student in self.students:
            print(f"Student: {student.name}")
            grades = student.get_grades()
            for subject, grade in grades.items():
                print(f"{subject}: {grade}")
            print()

    def display_class_summary(self):
        print("Class Summary:")
        print(f"Highest Scores: {self.calculate_highest()}")
        print(f"Lowest Scores: {self.calculate_lowest()}")
        print(f"Class Averages: {self.calculate_class_average()}")


# Example usage
tracker = GradeTracker()
tracker.add_student("Alice", 85, 92, 78)
tracker.add_student("Bob", 67, 74, 58)
tracker.add_student("Charlie", 90, 88, 93)

tracker.display_student_grades()
tracker.display_class_summary()
