package infinity1087.android.com.examplehr.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import infinity1087.android.com.examplehr.R;
import infinity1087.android.com.examplehr.RoundedTransformation;
import infinity1087.android.com.examplehr.model2uglyApi.ResponseDetail;

public class RecyclerItems extends RecyclerView.Adapter<RecyclerItems.MyViewHolder> {

//    http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI

    List<ResponseDetail> mData;

    public RecyclerItems(List<ResponseDetail> data) {
        mData = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout
                .activity_row_item, viewGroup, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        ResponseDetail datum = mData.get(i);
        myViewHolder.txt_name.setText(datum.getP().getProductName());

        //TODO Read below fetched data using new api <http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/Product/1/BindByProductGroupID>
        //i replaced /1 with 2 for vegetables and 1 is for fruits but for 3 and 4 there is np data so for milk and waffers i couldnt find the url
        // if you get the number for milk and waffers just in MainActivity onClick buttons there is a method called callRetrofit(1,2,3,4) just replace the number in there you will understand  that all
        //also i couldnt find the image url for the new api just bu calling     datum.getP().getProductImage()    you will get the image name
        // just complete the whole url ("http  xyz "+ datum.getP().getProductImage() + " xyz" )
        //i have found out the solution for the spinner but it will take a while so will do it tom but each and every data is coming so dnt worry chill
        //just bring the new image url and milk and waffers url thats all.



        Picasso.get()
                .load("http://image.barodaweb.net/api/EGreen/Magic/270/ProductGroup-2/19bcec92c92b4a4b9a8c75e4a4e7e20e.jpg/100")
                .transform(new RoundedTransformation(14, 0))
                .into(myViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_name,txt_price;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_item_name);
            imageView = itemView.findViewById(R.id.img_detail);
            txt_price=itemView.findViewById(R.id.txt_detail_amount);

        }
    }
}
