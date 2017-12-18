package com.ajay.problems;

import java.util.Scanner;

/**
 * Created by ajayk297 on 18/12/17.
 */
public class MinimumTimeToCompleteAllJobs {

        /**
         * For finding the minimum time required to complete a set of jobs.
         *
         */
        public static int findMinimumTimeToCompleteAllJobs(int arr[], int n, int t) {

        int size = arr.length;
        System.out.println("Size : " + size);

        //max task which can be assigned to a person
        int maxTaskPerAssignee = ((int) Math.ceil((float) size / (float) n));

        System.out.println("maxTaskPerAssignee : " + maxTaskPerAssignee);

        //Algo to find the maximum sum of task required among the provided tasks
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int jobCount = 0;
        for (int i : arr) {
            sum += i;
            jobCount++;
            if (sum >= maxTaskPerAssignee * t || jobCount >= maxTaskPerAssignee) {
                if (sum > maxSum)
                    maxSum = sum;
                sum = 0;
                jobCount = 0;
            }
        }

        return maxSum * t;
    }


        /**
         * Given an array of jobs with different time requirements. There are K identical assignees available and we are also given how much time an assignee takes to do one unit of job. Find the minimum time to finish all jobs with following constraints.
         * An assignee can be assigned only contiguous jobs. For example, an assignee cannot be assigned jobs 1 and 3, but not 2.
         * Two assignees cannot share (or co-assigned) a job, i.e., a job cannot be partially assigned to one assignee and partially to other.
         * Problem Statement url -http://www.geeksforgeeks.org/find-minimum-time-to-finish-all-jobs-with-given-constraints/
         * @param args
         */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of assignees (N)- ");
        int n = sc.nextInt();

        System.out.println("Enter time taken by assignee to finish one unit of job (T)- ");
        int t = sc.nextInt();

        System.out.println("Enter size for job array (job[])- ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter value for job array (job[])" + i + " - ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Min Time: " + findMinimumTimeToCompleteAllJobs(arr, n, t));

    }
}
