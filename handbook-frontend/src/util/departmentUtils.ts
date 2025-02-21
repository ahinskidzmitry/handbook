import type { Department } from "../models/Department";

export function flatDepartments(departments: Department[]): Department[] {
    const flattenDepartments: Department[] = [];
    for (const department of departments) {
        flattenDepartments.push(department);
        if (department.children) {
            flattenDepartments.push(...flatDepartments(department.children));
        }
    }
    return flattenDepartments;
}