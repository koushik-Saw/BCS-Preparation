package com.example.bcs_preparation.view.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bcs_preparation.R;
import com.example.bcs_preparation.adapter.ExamQuestionAdapter;
import com.example.bcs_preparation.databinding.FragmentExamQuestionBinding;
import com.example.bcs_preparation.model.ExamQuestionModel;
import com.example.bcs_preparation.utils.custom_dialog.SyllabusDialog;
import com.example.bcs_preparation.viewmodel.ExamQuestionViewModel;
import com.google.gson.JsonArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExamQuestionFragment extends Fragment implements ExamQuestionAdapter.ItemClickListener{

    private FragmentExamQuestionBinding binding;
    private ExamQuestionViewModel examQuestionViewModel;
    private List<ExamQuestionModel.Question> questionList;
    List<ExamQuestionModel.Question__1> allQuestion = new ArrayList<>();
    List<String> questionName = new ArrayList<>();
    List<ExamQuestionModel.Question__1> questionListData = new ArrayList<>();
    Map<String, List<ExamQuestionModel.Question__1>> questionMap = new HashMap<>();
    private ExamQuestionAdapter examQuestionAdapter;
    private ProgressDialog progressDialog;
    private String spinerQuesName;
    List<ExamQuestionModel.Question__1> list = new ArrayList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentExamQuestionBinding.inflate(inflater,container,false);

        binding.examQuestionRVID.setLayoutManager(new LinearLayoutManager(requireActivity()));

        progressDialog = new ProgressDialog(requireActivity());
        showProgressDialog();


        examQuestionViewModel = new ViewModelProvider(requireActivity()).get(ExamQuestionViewModel.class);

        examQuestionViewModel.getExamQuestion().observe(requireActivity(), new Observer<HashMap<String, List<ExamQuestionModel.Question__1>>>() {
            @Override
            public void onChanged(HashMap<String, List<ExamQuestionModel.Question__1>> stringListHashMap) {
                progressDialog.dismiss();
                questionName.clear();
                questionMap.clear();
                allQuestion.clear();

                for ( Map.Entry<String, List<ExamQuestionModel.Question__1>> entry : stringListHashMap.entrySet()) {
                    questionName.add(entry.getKey());
                    questionMap.put(entry.getKey(),entry.getValue());
                    Log.e("onChanged", "onChanged: "+entry.getKey()+" "+entry.getValue().get(0).getSubject());
                }

                spinerQuesName = questionName.get(0);

                initSpinner();
            }
        });

        return binding.getRoot();
    }


    private void initSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                requireActivity(),
                android.R.layout.simple_spinner_dropdown_item,
                questionName
        );

        binding.examQuestionSPID.setAdapter(adapter);

        binding.examQuestionSPID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                allQuestion.clear();
                spinerQuesName = parent.getItemAtPosition(position).toString();

                Log.e("spinerQuesName", "onItemSelected: "+questionMap.get(spinerQuesName).size() );
                Log.e("spinerQuesName", "onItemSelected: "+spinerQuesName );

                for(int i=0;i<questionMap.get(spinerQuesName).size();i++){
                    allQuestion.add(questionMap.get(spinerQuesName).get(i));
                    Log.e("onItemSelected", "onItemSelected: "+allQuestion.get(0).getSubject() );
                }


                examQuestionAdapter = new ExamQuestionAdapter(requireActivity(),allQuestion,ExamQuestionFragment.this::onClick);
                binding.examQuestionRVID.setAdapter(examQuestionAdapter);

                Toast.makeText(requireActivity(), ""+spinerQuesName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void showProgressDialog() {
        progressDialog.setMessage("Loading....");
        progressDialog.setIcon(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    @Override
    public void onClick(View v,int id,int value) {
        switch (value){
            case 0 :
                SyllabusDialog dialog = new SyllabusDialog("ব্যাখা",allQuestion.get(id).getExplanation());
                dialog.setCancelable(false);
                dialog.show(getChildFragmentManager(),"SyllabusDialog");
                Log.e("getExplanation", "onClick: "+allQuestion.get(id).getExplanation() );
                break;
            case 1 :
                /*Navigation.findNavController(binding.examQuestionLLSPID).navigate(R.id.action_ExamQuestionFragment_to_playlistfragment);*/
               /* AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                View dialogview = LayoutInflater.from(v.getRootView().getContext()).inflate(R.layout.fragment_favourite_question_playlist,null);
                builder.setView(dialogview);
                builder.setCancelable(true);
                builder.show(); */
                FavouriteQuestionPlaylist favouriteQuestionPlaylist = new FavouriteQuestionPlaylist();
                favouriteQuestionPlaylist.show(getParentFragmentManager(),"");
                break;
        }
    }
}